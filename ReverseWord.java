package com.niuke.problems;

import java.util.Stack;

public class ReverseWord {
	//方法1：使用栈
	public String ReverseSentence(String str) {
       Stack<String> stack = new Stack<String>();
       if(str == null || str.trim().length()==0) return str;
       StringBuilder sb1 = new StringBuilder();
       int len = str.length();
       for(int i=0;i<len;i++){
    	   char c = str.charAt(i);
    	   if(c == ' '){
    		   stack.push(sb1.toString()+" ");
    		   sb1 = new StringBuilder();
    	   }else{
    		   sb1.append(c);
    	   }    	   
       }
       
       StringBuilder sb = new StringBuilder();
       sb.append(sb1+" ");
       while(!stack.empty()){
    	   sb.append(stack.pop()+" ");
       }
       return sb.toString().trim();
    }
	
	//按空格分割，然后倒序输出
	public String ReverseSentence1(String str) {
		if(str == null || str.trim().length()==0) return str;
		StringBuilder sb = new StringBuilder();
		String[] strs = str.split(" ");
		for(int i=strs.length-1;i>=0;i--){
			if(i>0) sb.append(strs[i]+" ");
			else sb.append(strs[i]);
		}
		return sb.toString();
	}
	
}
