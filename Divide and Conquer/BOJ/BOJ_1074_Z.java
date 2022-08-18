package com.ssafy.day0817;

import java.util.Scanner;

public class BOJ_1074_Z {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		z((int) Math.pow(2, sc.nextInt()), sc.nextInt(), sc.nextInt());
		System.out.println(cnt);
	}

	private static void z(int n, int r, int c) {
		if(n == 2) {
			if		(r == 0 && c == 1) cnt += 1;
			else if (r == 1 && c == 0) cnt += 2;
			else if (r == 1 && c == 1) cnt += 3;
			return;
		}
		int h = n / 2;
		int skip = 3;
		if		(r < h && c < h) skip = 0;
		else if (r < h && c >= h) skip = 1;
		else if (r >= h && c < h) skip = 2;
		cnt += h * h * skip;
		
		z(h, r % h, c % h);
	}
}
