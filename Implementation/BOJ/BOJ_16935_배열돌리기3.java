package com.ssafy.day0810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
	static int[][] map;
	static int[][] map2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());	// row
		int M = Integer.parseInt(st.nextToken());	// column
		int R = Integer.parseInt(st.nextToken());	// 연산횟수
		// 배열 받기
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		// 연산 타입받아서 연산 수행
		st = new StringTokenizer(br.readLine());
		int type;
		for (int i = 0; i < R; i++) {
			type = Integer.parseInt(st.nextToken());
			switch (type) {
			case 1:
				reversal(map.length, map[0].length);
				break;
			case 2:
				reversal2(map.length, map[0].length);		
				break;
			case 3:
				rotation(map.length, map[0].length);
				break;
			case 4:
				rotation2(map.length, map[0].length);				
				break;
			case 5:
				subArr(map.length, map[0].length);
				break;
			case 6:
				subArr2(map.length, map[0].length);				
				break;
			}
		}
		// 연산 결과 출력
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void subArr2(int a, int b) {	// 6
		int[] change1 = {a/2, 0, 0, a/2};
		int[] change2 = {0, 0, b/2, b/2};
		map2 = new int[a][b];
		for (int i = 3; i >= 0; i--) {
			if(i == 0) {
				for (int j = change1[i], x = change1[3]; j < change1[i] + a/2; j++) {
					for (int k = change2[i], y = change2[3]; k < change2[i] + b/2; k++) {
						map2[x][y++] = map[j][k];
					}
					x++;
				}
			}else {
				for (int j = change1[i], x = change1[i - 1]; j < change1[i] + a/2; j++) {
					for (int k = change2[i], y = change2[i - 1]; k < change2[i] + b/2; k++) {
						map2[x][y++] = map[j][k];
					}
					x++;
				}
			}
		}
		map = map2.clone();
	}
	private static void subArr(int a, int b) {	// 5
		int[] change1 = {a/2, 0, 0, a/2};
		int[] change2 = {0, 0, b/2, b/2};
		map2 = new int[a][b];
		for (int i = 0; i < 4; i++) {
			if(i == 3) {
				for (int j = change1[i], x = change1[0]; j < change1[i] + a/2; j++) {
					for (int k = change2[i], y = change2[0]; k < change2[i] + b/2; k++) {
						map2[x][y++] = map[j][k];
					}
					x++;
				}
			}else {
				for (int j = change1[i], x = change1[i + 1]; j < change1[i] + a/2; j++) {
					for (int k = change2[i], y = change2[i + 1]; k < change2[i] + b/2; k++) {
						map2[x][y++] = map[j][k];
					}
					x++;
				}
			}
		}
		map = map2.clone();
	}
	private static void rotation2(int a, int b) {	// 4
		map2 = new int[b][a];
		for (int i = b - 1, x = 0; i >= 0; i--) {
			for (int j = 0, y = 0; j < a; j++) {
				map2[x][y++] = map[j][i];
			}
			x++;
		}
		map = map2.clone();
	}
	private static void rotation(int a, int b) {	// 3
		map2 = new int[b][a];
		for (int i = 0, x = 0; i < b; i++) {
			for (int j = a - 1, y = 0; j >= 0; j--) {
				map2[x][y++] = map[j][i];
			}
			x++;
		}
		map = map2.clone();
	}
	private static void reversal2(int a, int b) {	// 2
		map2 = new int[a][b];
		for (int i = b - 1, x = 0; i >= 0; i--) {
			for (int j = 0, y = 0; j < a; j++) {
				map2[y++][x] = map[j][i];
			}
			x++;
		}
		map = map2.clone();
	}
	private static void reversal(int a, int b) {	// 1
		map2 = new int[a][b];
		for (int i = a - 1, x = 0; i >= 0; i--) {
			for (int j = 0, y = 0; j < b; j++) {
				map2[x][y++] = map[i][j];
			}
			x++;
		}
		map = map2.clone();
	}
}
