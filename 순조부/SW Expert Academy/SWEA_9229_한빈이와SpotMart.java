package com.ssafy.day0808;

import java.util.Scanner;

public class SWEA_9229_한빈이와SpotMart {
	static int M;
	static int maxSum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int N = sc.nextInt();
			M = sc.nextInt();
			maxSum = 0;
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			boolean[] visit = new boolean[N];
			comb(arr, visit, 2, 0);
			if(maxSum == 0) {
				maxSum = -1;
			}
			sb.append("#" + test_case + " " + maxSum + "\n");
		}
		System.out.println(sb);
	}
	static void comb(int[] arr, boolean[] visit, int r, int depth) {
		if(r == 0) {
			int sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if(visit[j]) {
					sum += arr[j];
				}
			}
			if(sum <= M) {					
				maxSum = Math.max(maxSum, sum);
			}
			return;
		}
		if(depth == arr.length) {
			return;
		}
		visit[depth] = true;
		comb(arr, visit, r-1, depth + 1);
		visit[depth] = false;
		comb(arr, visit, r, depth + 1);
	}
}
