package com.niuke.problems;

public class ChildJoseph {
	//直接在原数组上进行操作
	public int LastRemaining_Solution(int n, int m) {
		if(n<=0 || m<=0) return -1;
        int[] children = new int[n];
        int num = 0;
        int i = 0, count = 0;
        while(num != n-1){
        	if(i==n) i=0;
        	if(children[i] == 0){
        		count++;
        		if(count == m){
        			num++;
        			count = 0;
        			children[i] = 1;
        		}
        	}
        	i++;
        }
        int res = 0;
        for(i=0;i<n;i++){
        	if(children[i] == 0){
        		res = i;
        		break;
        	}
        }
        return res;        
    }
	
	//方法2：使用循环链表
	public int LastRemaining_Solution1(int n, int m) {
		Person head = null, q = null;
		for(int i=0;i<n;i++){
			Person p = new Person(i);
			if(head == null){
				head = p;
				q = p;
			}else{
				q.next = p;
				q = q.next;
			}
		}
		q.next = head;
		Person p = head;
		int number = 0, count = 0;
		while(p.next != p){
			count++;
			if(count == m){
				number++;
				count = 0;
				q.next = p.next;
			}
			q = p;
			p = p.next;
		}
		return p.number;
	}
	
	//方法3：数学推导
	/*
	 * 设f(n,m)表示n个人数到m退出的最后结果，则第一次数到m-1时记为k：
	 * 0,1,...,k,k+1,...,n-1，之后从k+1开始数，设q(n-1,m)来代替这一过程，显然f(n,m) = q(n-1,m);
	 * 一次退出之后的报数过程是： k+1,k+2,...,n-1,0,1,...,k-1
	 * 作变换k+1 -> 0, k+2 -> 1,....,k-1 -> n-2，则变换函数是p(x) = (x-k-1)%n,其你函数是p'(x)=(x+k+1)%n;
	 * 可知f(n,m) = q(n-1,m) = p'(f(n-1,m)) = (f(n-1,m)+k+1)%n， 
	 * 由于k=m-1，则最终结果是f(n,m) = (f(n-1,m)+m)%n; 具有递归关系，且f(1,m) = 0
	 */
	public int LastRemaining_Solution2(int n, int m) {
		if(n<=0 || m<=0) return -1;
		int res = 0;
		for(int i=2;i<=n;i++){
			res = (res+m)%i;
		}
		return res;
	}
}

class Person{
	int number;
	Person next;
	public Person(int n){
		this.number = n;
	}
}
