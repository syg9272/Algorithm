package com.ssafy.day0809;

import java.util.Scanner;

public class SWEA_6485_삼성시의버스노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int N = sc.nextInt();
			int[][] bus = new int[N][2];
			for (int i = 0; i < N; i++) {
				bus[i][0] = sc.nextInt();
				bus[i][1] = sc.nextInt();
			}
			int P = sc.nextInt();
			int[] num = new int[P];
			for (int i = 0; i < P; i++) {
				num[i] = sc.nextInt();
			}
			int[] busStop = new int[5000];
			for (int i = 0; i < bus.length; i++) {
				for (int j = bus[i][0] - 1; j < bus[i][1]; j++) {
					busStop[j]++;
				}
			}
			sb.append("#" + test_case + " ");
			for (int i = 0; i < P; i++) {
				sb.append(busStop[num[i]-1] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
