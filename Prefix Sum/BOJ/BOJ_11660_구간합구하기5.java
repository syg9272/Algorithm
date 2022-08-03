package com.ssafy.day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {				
				map[i][j] = map[i][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		int x1;
        int y1;
        int x2;
        int y2;
		for (int i = 0; i < m; i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			for (int j = 0; j < x2 - x1 + 1; j++) {
				sum += map[x1 + j][y2] - map[x1 + j][y1 - 1];
			}
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}
}
