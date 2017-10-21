package com.niuke.problems;

import java.util.Scanner;

/**
 * 一只袋鼠要从河这边跳到河对岸，河很宽，但是河中间打了很多桩子，每隔一米就有一个，每个桩子上都有一个弹簧，袋鼠跳到弹簧上就可以跳的更远，
 * 每个弹簧力量不同，用一个数字代表它的力量，如果弹簧力量为5，就代表袋鼠下一跳最多能够跳5米，如果为0，就会陷进去无法继续跳跃，河流一共N米宽，
 * 袋鼠初始位置就在第一个弹簧上面，要跳到最后一个弹簧之后就算过河了，给定每个弹簧的力量，求袋鼠最少需要多少跳能够到达对岸。如果无法到达输出-1；
 * @author Dian
 *
 */
public class RiverCrossing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nstr = sc.nextLine();
		String[] strs = sc.nextLine().split(" ");
		int n = Integer.parseInt(nstr);
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(strs[i]);
		}
		System.out.println(crossRiver(n,arr));
		System.out.println(crossRiver1(n,arr));
	}
	
	/**
	 * 动态规划1
	 * 设dp[i]表示达到i米所需要的最小跳跃次数，arrive[i]表示是否能够到达i米（0和1表示）
	 * 假设当前在i米位置，那么能够到达的范围是i-arr[i]+i，将这中间所有的位置的次数置为dp[i]+1
	 * 题目要求到达n米之后，就相当于能够到达n+1米
	 * @param n
	 * @param arr
	 * @return
	 */
	private static int crossRiver(int n, int[] arr) {
		//定义dp和arrive数组，长度为n+1，dp[i]表示到达i+1米需要的最小次数
		int[] dp = new int[n+2];
		int[] arrive = new int[n+2];
		//开始在第一个弹簧
		dp[1] = 0;
		arrive[1] = 1;
		//将第一个弹簧能够到达的位置进行标记，注意数组越界问题
		for(int i=2;i<=arr[0]+1&&i<=n+1;i++){
			dp[i] = 1;
			arrive[i] = 1;
		}
		//从第二个弹簧开始依次计算
		for(int i=2;i<=n;i++){
			if(arr[i-1]==0) continue;
			//从当前位置开始，依次对后面能够到达但是还没有标记的位置进行标记，并将次数+1，注意数组越界问题
			for(int j=i+1;j<=arr[i-1]+i&&j<=n+1;j++){
				if(arrive[i]==1&&arrive[j]==0){
					dp[j] = dp[i]+1;
					arrive[j] = 1;
				}
			}
		}
		if(arrive[n+1]==0) return -1;
		return dp[n+1];
	}
	
	//改进，合并内循环
	private static int crossRiver1(int n, int[] arr) {
		//定义dp和arrive数组，长度为n+1，dp[i]表示到达i+1米需要的最小次数
		int[] dp = new int[n+2];
		int[] arrive = new int[n+2];
		//开始在第一个弹簧
		dp[1] = 0;
		arrive[1] = 1;

		//从第二个弹簧开始依次计算
		for(int i=1;i<=n;i++){
			if(arr[i-1]==0) continue;
			//从当前位置开始，依次对后面能够到达但是还没有标记的位置进行标记，并将次数+1，注意数组越界问题
			for(int j=i+1;j<=arr[i-1]+i&&j<=n+1;j++){
				if(arrive[i]==1&&arrive[j]==0){
					dp[j] = dp[i]+1;
					arrive[j] = 1;
				}
			}
		}
		if(arrive[n+1]==0) return -1;
		return dp[n+1];
	}
}
