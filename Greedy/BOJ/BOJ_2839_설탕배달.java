package com.ssafy.day0816;

import java.util.Scanner;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		while(true) {
			if(N % 5 == 0) {
				cnt += N / 5;
				break;
			}else {
				cnt ++;
				N -= 3;
			}
		}
		if(N < 0) cnt = -1;
		System.out.println(cnt);
	}
}
