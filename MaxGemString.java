package com.niuke.problems;

import java.util.Scanner;

/**
 * 有一条彩色宝石项链，是由很多种不同的宝石组成的，包括红宝石，蓝宝石，钻石，翡翠，珍珠等。有一天国王把项链赏赐给了一个学者，并跟他说，
 * 你可以带走这条项链，但是王后很喜欢红宝石，蓝宝石，紫水晶，翡翠和钻石这五种，我要你从项链中截取连续的一小段还给我，这一段中必须包含所有的这五种宝石，
 * 剩下的部分你可以带走。如果无法找到则一个也无法带走。请帮助学者找出如何切分项链才能够拿到最多的宝石。
 * @author Dian
 *
 */
public class MaxGemString {
    public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
         System.out.println(gem(sc.nextLine()));
	}

	private static int gem(String str) {
		int len = str.length();
		String temp = "";
		int x = 0;
		for(x=5;x<len;x++){  //每次截取x阁字符，看看是否包含ABCDE，如果满足条件则立即返回
			for(int y=0;y<len;y++){
				//利用闭环特性
				if(y>len-x)
					temp = str.substring(y)+str.substring(0, x-len+y);
				else temp = str.substring(y,y+x);
				//System.out.println(temp);
				if(temp.contains("A")&&temp.contains("B")&&temp.contains("C")&&temp.contains("D")
						&&temp.contains("E")){
					return len-x; 
				}
			}			
		}
		return 0;
	}
}
