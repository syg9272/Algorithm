package com.ssafy.recur;

public class Test03 {
	static int sum = 0;
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		// solve 함구수현 : 매개변수는 자유롭게 설정
		// 베열의 합
		solve(arr, arr.length-1);
		System.out.println(sum);
		
		System.out.println(solve2(arr, 0));
	}
	
	static void solve(int[] arr, int i) {
		if(i < 0) return;
		solve(arr, i-1);
		sum += arr[i];
	}
	
	static int solve2(int[] arr, int index) {
		if(index == arr.length) return 0;
		return arr[index] + solve2(arr, index + 1);
	}
}
