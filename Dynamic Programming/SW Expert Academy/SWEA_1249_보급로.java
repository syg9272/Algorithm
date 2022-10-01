package com.ssafy.day0930;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SWEA_1249_보급로 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N + 1][N + 1];
			int [][] dp = new int[N + 1][N + 1];
			// map 입력 받으면서 dp배열 맥스값으로 채워놓기
			for (int i = 1; i <= N; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 1; j <= N; j++) {
					map[i][j] = c[j - 1] - '0';
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
			
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {1, 1, 0});
			
			while(!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] temp = q.poll();
					for (int d = 0; d < 4; d++) {
						int nx = temp[0] + dx[d];
						int ny = temp[1] + dy[d];
						// 인덱스 유효범위 밖이면 무시
						if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
						// 메모해놓은 시간보다 적게 걸리거나 처음 방문한 경우 여태까지 걸린 시간 + 현재 위치 복구시간 저장
						if(dp[nx][ny] > temp[2] + map[nx][ny] || dp[nx][ny] == Integer.MAX_VALUE) {
							dp[nx][ny] = temp[2] + map[nx][ny];
							q.offer(new int[] {nx, ny, temp[2] + map[nx][ny]});
						}
					}
				}
			}
			sb.append("#" + t + " " + dp[N][N] + "\n");
		}
		
		System.out.println(sb);
	}
}
