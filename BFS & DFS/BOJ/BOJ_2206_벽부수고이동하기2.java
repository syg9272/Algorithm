// dfs로 풀었지만 시간초과 ...........

package com.ssafy.day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기2 {	// dfs
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] map;
	static int N, M, ans = Integer.MAX_VALUE;
	static boolean[][] visited;
	static boolean valid;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		
		visited[0][0] = true;
		breakWall(0, 0, 0, 1);
		
		System.out.println( ans == Integer.MAX_VALUE ? -1 : ans );
	}
	private static void breakWall(int r, int c, int wall, int cnt) {
		if(r == N - 1 && c == M - 1) {
			ans = Math.min(ans, cnt);
			return;
		}
		if(wall > 1) return;
		for (int d = 0; d < 4; d++) {
			int nx = r + dx[d];
			int ny = c + dy[d];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
			visited[nx][ny] = true;
			if(map[nx][ny] == 0) {
				breakWall(nx, ny, wall, cnt + 1);
				visited[nx][ny] = false;
			} else {
				breakWall(nx, ny, wall + 1, cnt + 1);
			}
		}
	}
}
