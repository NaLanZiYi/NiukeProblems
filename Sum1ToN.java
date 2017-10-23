package com.niuke.problems;

public class Sum1ToN {
	/*
	 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case
	 * 等关键字及条件判断语句（A?B:C）。
	 */
	
	//迭代，利用逻辑运算符短路特性
	public int Sum_Solution(int n) {
		int sum = 0;
		boolean tag = (n>0) && (sum += Sum_Solution(n-1)+n)>0;
		return sum;
	}
	
	
	//问题的关键是触发递归结束的条件，可以利用模0异常
	public int Sum_Solution1(int n) {
		try{
			int i = 1%n;
			int sum = 0;
			return n + Sum_Solution(n-1);
		}catch(Exception e){
			return 0;
		}
	}
}
