package com.ssafy.day0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= t; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n + m][n + m];
			int[][] map2 = new int[n + m][n + m];
			int[][] map3 = new int[n + m][n + m];
			int num;
			for (int i = m; i < n + m; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = m; j < n + m; j++) {
					num = Integer.parseInt(st.nextToken());
					map2[i][j] = num;
					map[i][j] = num + map[i][j - 1] - map2[i][j - m];
					map3[i][j] = map[i][j];
				}
			}
			for (int i = ((2 * m) - 1); i < n + m; i++) {
				for (int j = m; j < n + m; j++) {
					map[j][i] = map[j][i] + map[j - 1][i] - map3[j - m][i];
				}
			}
			int maxSum = 0;
			for (int i = ((2 * m) - 1); i < n + m; i++) {
				for (int j = ((2 * m) - 1); j < n + m; j++) {
					maxSum = Math.max(maxSum, map[i][j]);
				}
			}
			sb.append("#" + test_case + " " + maxSum + "\n");
		}
		System.out.println(sb);
	}
}
