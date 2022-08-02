package com.ssafy.recur;

public class Test01 {
	static int sum = 0;
	public static void main(String[] args) {
		System.out.println("반복을 이용한 합계 : " + solve1(10));
		solve2(10);
		System.out.println("재귀를 이용한 합계 : " + sum);
		System.out.println("재귀를 이용한 합계 : " + solve3(10));
		System.out.println("재귀를 이용한 합계 : " + solve4(10, 0));
	}
	public static int solve1(int num) {
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		return sum;
	}
	
	static void solve2(int num) {
		if(num == 0) return;
		solve2(num-1);
		sum += num;
	}
	
	static int solve3(int num) {
		if(num == 1) return num;
		else return num + solve3(num-1);
	}
	
	static int solve4(int num, int sum) {
		if(num == 0) return sum;
		return solve4(num - 1, sum + num);
	}
}
