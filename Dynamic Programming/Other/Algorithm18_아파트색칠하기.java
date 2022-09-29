/*
 * (노 - 노,파  /  파 - 노)
 * 
 * 1층 = 2 
 * 2층 = 3
 * 3층 = 5
 * .
 * .
 * .
 * 3층 = 1층 + 2층
 */
package com.ssafy.day0929;

public class Algorithm18_아파트색칠하기 {
	static int n;
	static int[] arr;
	public static void main(String[] args) {
		n = 9;
		arr = new int[n + 1];
		System.out.println(dp(n));
	}
	private static int dp(int cnt) {
		arr[1] = 2;
		arr[2] = 3;
		
		for (int i = 3; i <= cnt; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		return arr[cnt];
	}
}
