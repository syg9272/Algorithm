package com.ssafy.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {
	static int[] dx = {-1, 1, 0, 0};	// 좌 -> 우 -> 상 -> 하
	static int[] dy = {0, 0, -1, 1};
	static int cnt = 0;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[100][100];
		int x;
		int y;
		cnt = 0;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) {
					count(i, j);
				}
			}
		}
		for (int i = 0; i < args.length; i++) {
			if(map[99][i] == 1) cnt++;
			if(map[i][99] == 1) cnt++;
		}
		
		
		System.out.println(cnt);
	}
	static void count(int i, int j) {
		int r = i;
		int c = j;
		for (int k = 0; k < 4; k++) {
			if(r + dx[k] >= 0 && r + dx[k] < 100 && c + dy[k] >= 0 && c + dy[k] < 100) {				
				if (map[r + dx[k]][c + dy[k]] == 0) {
					cnt++;
				}
			}else cnt++;
		}
	}
}
