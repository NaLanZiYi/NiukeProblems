package com.niuke.problems;

public class StringToInteger {
	public int StrToInt(String str) {
		if(str == null || str.length() == 0) return 0;
        int flag = 1;    //记录符号
        int i = 0;
        while(str.charAt(i) == ' ') i++;
        char c = str.charAt(i);
        if(c == '-') flag = -1;
        if(c == '-' || c == '+')i++;
        int num = 0;
        for(;i<str.length();i++){
        	c = str.charAt(i);
        	if(c-'0'>9 || c-'0'<0) return 0;
        	num = num*10+(c-'0');
        }
        return num*flag;
    }
}
