package com.ssafy.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[][] map;
	static boolean[][] visited;
	static int ans, h, w;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];
			ans = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						ans++;
						land(i, j);
					}
				}
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
	private static void land(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int[] idx = q.poll();
			int x = idx[0];
			int y = idx[1];
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	private static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nr < h && nc >= 0 && nc < w) return true;
		return false;
	}
}
