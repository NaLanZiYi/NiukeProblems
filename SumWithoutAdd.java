package com.niuke.problems;

public class SumWithoutAdd {
	public int Add(int num1,int num2) {        
        while(num2 != 0){
        	int tmp = num1 ^ num2;  //用异或计算不带进位的相加结果
        	num2 = (num1 & num2) << 1;  //与运算计算进位，进位需要加在左边一位，所以需要左移
        	num1 = tmp;
        }
        return num1;
    }
}
