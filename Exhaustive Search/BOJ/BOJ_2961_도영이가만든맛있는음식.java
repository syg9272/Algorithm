package com.ssafy.day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	static int[][] taste;
	static int[][] idx;
	static int minSum = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {			// 부분집합
			idx = new int[i][2];
			comb(0, 0);
		}
		System.out.println(minSum);
	}

	private static void comb(int r, int start) {
		if(r == idx.length) { // 기저조건에 닿을 경우 신맛과 쓴맛의 차이의 최소값 구하기
			int mul = 1;
			int sum = 0;
			int result;
			for (int i = 0; i < idx.length; i++) {
				mul *= idx[i][0];
				sum += idx[i][1];
			}
			result = Math.abs(mul - sum);
			minSum = Math.min(minSum, result);
			return;
		}
		if(start == taste.length) return;
		idx[r] = Arrays.copyOf(taste[start], 2);
		comb(r + 1, start + 1);
		comb(r, start + 1);
	}
}
