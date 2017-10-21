package com.niuke.problems;

public class ROLString {
	
	public static void main(String[] args) {
		String s = LeftRotateString("abcdefg",2);
		System.out.println(s);
	}
	
	public static String LeftRotateString(String str,int n) {
        if(str == null) return "";
        int len = str.length();
        if(len==0) return "";
        n = n % len;
        String result = str.substring(n,len) + str.substring(0,n);
        return result;
        
        //方法二：使用O(n)额外空间
//		int len = str.length();
//		if(len == 0) return "";
//		n = n % len;
//		str += str;
//		System.out.println(str);
//		return str.substring(n, len);
    }
	
	/*
	 * 令str = XY，要求得YX，利用(XTYT)T = YX，即前后两段分别翻转，最后整体翻转
	 */
	public static String LeftRotateString1(String str,int n) {
        if(str == null) return "";
        int len = str.length();
        if(len == 0) return "";
        n = n % len;
        String str1 = new StringBuffer(str.substring(0,n)).reverse().toString();
        String str2 = new StringBuffer(str.substring(n,len)).reverse().toString();
        return new StringBuffer(str1+str2).reverse().toString();
    }
}
