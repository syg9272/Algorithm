package com.ssafy.recur;

public class Test02 {
	public static void main(String[] args) {
		System.out.println("반복을 이용한 자리수의 합 구하기 : " + solve1(13689));
		System.out.println("재귀를 이용한 자리수의 합 구하기 : " + solve2(13689));
	}

	static int solve1(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}

	static int solve2(int num) {
		if(num < 10) return num;
		else return num % 10 + solve2(num / 10);
	}
}
