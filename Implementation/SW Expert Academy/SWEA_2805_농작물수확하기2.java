/*
 * ① 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
 * ② 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
 */
package com.ssafy.day0803;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SWEA_2805_농작물수확하기2 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/2805.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int ans = 0;
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] data = sc.next().toCharArray();
				for (int j = 0; j < data.length; j++) {
					farm[i][j] = data[j] - '0';
				}
			}
			int center = N / 2;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if((Math.abs(center - i) + Math.abs(center- j)) <= center) {
						ans += farm[i][j];
					}
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
