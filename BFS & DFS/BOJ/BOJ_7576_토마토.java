package com.ssafy.day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		boolean[][] visited = new boolean[M][N];		

		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					visited[i][j] = true;
					q.offer(new int[] {i, j, 0});
				}
			}
		}
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] idx = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = idx[0] + dx[d];
					int ny = idx[1] + dy[d];
					if(nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny] == -1 || map[nx][ny] == 1) continue;
					if(!visited[nx][ny] && map[nx][ny] == 0) {						
						map[nx][ny] = 1;
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, idx[2] + 1});
					}
				}
			}
			time++;
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(time - 1);
	}
}
