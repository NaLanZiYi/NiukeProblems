package com.niuke.problems;

import java.util.ArrayList;

public class TwoSumEqualsS {
	public static void main(String[] args) {
		int[] array = {1,2,4,11,15};
		ArrayList<Integer> list = FindNumbersWithSum(array, 15);
		for(int i : list)
			System.out.print(i+" ");
	}
	
	/*
	 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
	 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
	 */
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array==null || array.length<2) return list;
		int len = array.length;
		int left = 0, right = len-1;
		int s = 0, b = 0;
		boolean tag = false;
		long max = Long.MAX_VALUE;
		while(left<right){
			int s1 = array[left] + array[right];
			if(s1 == sum){
				if(array[left] * array[right]<max){
					max = array[left] * array[right];
					s = array[left];
					b = array[right];
					tag = true;
				}
				left++;
			}else if(s1 < sum){
				left++;
			}else{
				right--;
			}
		}
		if(tag){			
			list.add(s);
			list.add(b);
		}
		return list;
    }
	
	public static ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(array==null || array.length<2) return list;
		int len = array.length;
		int left = 0, right = len-1;
		int s = 0, b = 0;
		while(left<right){
			int s1 = array[left] + array[right];
			if(s1 == sum){
				s = array[left];
				b = array[right];
				list.add(s);
				list.add(b);
				break;   //找到的第一组即是乘积最小的
				/*
				 * 找到的第一组（相差最大的）就是乘积最小的。可以这样证明：考虑x+y=C（C是常数）
				 * ，x*y的大小。	 * 不妨设y>=x，y-x=d>=0，即y=x+d, 2x+d=C, x=(C-d)/2, 
				 * x*y=x(x+d)=(C-d)(C+d)/4=(C^2-d^2)/4，也就是x*y是一个关于变量d的二次函数，对称轴是y轴，
				 * 开口向下。d是>=0的，d越大, x*y也就越小。
				 */
			}
			
			while(array[left]+array[right] > sum) right--;
			while(array[left]+array[right] < sum) left++;
		}
		
		return list;
	}
}
