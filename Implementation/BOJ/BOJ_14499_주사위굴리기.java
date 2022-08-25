package com.ssafy.day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14499_주사위굴리기 {
	static int[][] map;
	static int[] dice;
	static int N, M;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dice = new int[7];
		
		int[] dx = {0, 0, 0, -1, 1};
		int[] dy = {0, 1, -1, 0, 0};
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = x;
		int c = y;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int d = Integer.parseInt(st.nextToken());
			r += dx[d];
			c += dy[d];
			if(!tumble(r, c, d)) {
				r -= dx[d];
				c -= dy[d];
			}
		}
		System.out.println(sb);
	}

	private static boolean tumble(int r, int c, int type) {
		if(r < 0 || r >= N || c < 0 || c >= M) return false;
		switch (type) {
		case 1:
			int temp = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = dice[1];
			dice[1] = temp;
			break;

		case 2:
			int temp2 = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = dice[1];
			dice[1] = temp2;
			break;
		
		case 3:
			int temp3 = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp3;
			break;
		
		case 4:
			int temp4 = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp4;
			break;
		}
		if(map[r][c] == 0) map[r][c] = dice[6];
		else {
			dice[6] = map[r][c];
			map[r][c] = 0;
		}
		
		sb.append(dice[1] + "\n");
		return true;
	}
}
