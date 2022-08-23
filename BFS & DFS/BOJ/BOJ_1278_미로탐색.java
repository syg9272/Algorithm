package com.ssafy.codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m, cnt;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String[] temp = br.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		move(0, 0);
		System.out.println(map[n-1][m-1]);
	}
	
	private static void move(int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		boolean [][] visited = new boolean[n][m];
		visited[r][c] = true;
		cnt = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			if(r == n - 1 && c == m - 1) return;
			
			for(int i = 0; i < 4 ; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <0 || ny <0 || nx > n-1 || ny > m-1) continue;
				
				if(!visited[nx][ny] && map[nx][ny]==1) {
					visited[nx][ny] = true;
					map[nx][ny] = map[now[0]][now[1]]+1;
					q.offer(new int[] {nx, ny});				
				}
			}
		}
	}
}
