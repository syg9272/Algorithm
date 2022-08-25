package com.ssafy.day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055_탈출 {
	static char[][] map;
	static boolean[][] water, visited, checked;
	static int R, C, ans;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static boolean arrival;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		checked = new boolean[R][C];
		visited = new boolean[R][C];
		int startX = -1;
		int startY = -1;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}
		hedgehog(startX, startY);
		System.out.println((arrival ? ans : "KAKTUS"));
	}
	private static void hedgehog(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c, 0});
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			water = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(!water[i][j] && !checked[i][j] && map[i][j] == '*') {
						moveWater(i, j);
					}
				}
			}
			for (int i = 0; i < size; i++) {
				int[] idx = q.poll();
				int x = idx[0];
				int y = idx[1];
				int time = idx[2];
				map[x][y] = '.';
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(isIn(nx, ny) && map[nx][ny] != '*' && map[nx][ny] != 'X' && !visited[nx][ny]) {
						if(map[nx][ny] == 'D') {
							ans = time + 1;
							arrival = true;
							return;
						}
						map[nx][ny] = 'S';
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, time + 1});
					}
				}
			}
		}
	}
	private static void moveWater(int r, int c) {
		checked[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];
			if(isIn(nr, nc) && map[nr][nc] == '.') {
				map[nr][nc] = '*';
				water[nr][nc] = true;
			}
		}
	}
	private static boolean isIn(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
}
