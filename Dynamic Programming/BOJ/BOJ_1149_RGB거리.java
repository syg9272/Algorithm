package com.ssafy.day0929;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N + 1][3];
		int[][] price = new int[N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1번째 집 3가지 색상에 대한 비용 넣어두기
		for (int i = 0; i < 3; i++) {
			price[1][i] = map[1][i];
		}
		
		// 같은 색상 제외 나머지 중 최소비용합 저장
		for (int i = 2; i <= N; i++) {
			price[i][0] = Math.min(price[i - 1][1] + map[i][0], price[i - 1][2] + map[i][0]);
			price[i][1] = Math.min(price[i - 1][0] + map[i][1], price[i - 1][2] + map[i][1]);
			price[i][2] = Math.min(price[i - 1][0] + map[i][2], price[i - 1][1] + map[i][2]);
		}
		
		// N개의 집에 대해 비용을 다 저장했으면 최종 최소비용합 찾기
		long ans = 1000 * 1000;
		for (int i = 0; i < 3; i++) {
			ans = Math.min(ans, price[N][i]);
		}
		
		System.out.println(ans);
	}
}
