package com.ssafy.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JUNGOL_1175_주사위던지기2 {
	static int N, M;
	static int cnt = 0;
	static int[] num;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		perm(0, 0);
		System.out.println(sb);
	}
	private static void perm(int r, int sum) {
		if(r == N) {
			if(sum == M) {
				for (int i = 0; i < num.length; i++) {
					sb.append(num[i]+" ");
				}
				sb.append("\n");
			}
			return;
		}
		
		for (int i = 1; i <= 6; i++) {
			num[r] = i;
			perm(r + 1, sum + i);
		}
	}
}
