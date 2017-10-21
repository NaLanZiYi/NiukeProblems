package com.niuke.problems;

import java.util.ArrayList;

public class SequenceListSumS {
	public static void main(String[] args) {
		/*
		 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
		 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
		 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
		 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
		 */
	}
	
	//方法1
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    if(sum<3) return list;
	    int low = 1, high = 2;
	    while(low<(sum+1)/2){
	    	int s = (low+high)*(high-low+1)/2;
	    	if(s == sum ){
	    		ArrayList<Integer> list1 = new ArrayList<Integer>();
	    		for(int i=low;i<=high;i++){
	    			list1.add(i);
	    		}
	    		list.add(list1);
	    		low++;
	    	}else if(s<sum){
	    		high++;
	    	}else{
	    		low++;
	    	}
	    	
	    }
	    return list;
    }
	
	//方法2：数学公式计算
	//sum = (a1+an)*(an-a1+1)/2, 所以(an+a1)*(an-a1+1) = 2*sum = k*l(令k>l);则k和l一基一偶
	//可知k = an+a1, l = an-a1+1，解得 an = (k+l-1)/2, a1 = (k-l+1)/2;
	public ArrayList<ArrayList<Integer> > FindContinuousSequence1(int sum) {
	    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	    if(sum<3) return list;
	    int s = (int) Math.sqrt(2*sum);
	    for(int i=s;i>1;i--){
	    	if(2*sum % i == 0){
	    		int high = 2*sum / i;
	    		//保证一个奇数一个偶数
	    		if((i&1)==0 && (high&1)!=0 || (i&1)!=0 && (high&1)==0){
	    			int a1 = (high-i+1)/2;
		    		int an = (high+i-1)/2;
		    		//由于序列至少包含两个数，即an>a1，可知i>1
		    		ArrayList<Integer> list1 = new ArrayList<Integer>();
		    		for(int j=a1;j<=an;j++){
		    			list1.add(j);
		    		}
		    		list.add(list1);
	    		}
	    		
	    	}
	    }
	    return list;
    }
}
