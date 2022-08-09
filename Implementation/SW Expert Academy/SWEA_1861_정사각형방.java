package com.ssafy.day0809;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1861_정사각형방 {
	static int[][] map;
	static int N;
	static int[] dx = {-1, 1, 0, 0};	// x이동
	static int[] dy = {0, 0, -1, 1};	// y이동
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 개수
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());	// N
			map = new int[N][N]; 
			int result = 1;
			int minIdx = 1000000;
			for (int i = 0; i < N; i++) {		// 방 정보 받기		
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					search(i, j);
					if(result < cnt) {
						result = cnt;
						minIdx = map[i][j];
					}else if(result == cnt) {
						minIdx = Math.min(minIdx, map[i][j]);
					}
				}
			}
			sb.append("#" + test_case + " " + minIdx + " " + result + "\n");
		}
		System.out.println(sb);
	}
	static void search(int r, int c) {
		cnt = 1;
		for (int i = 0; i < 4; i++) {
			if(r + dx[i] >= 0 && r + dx[i] < N && c + dy[i] >= 0 && c + dy[i] < N
					&& map[r + dx[i]][c + dy[i]] - map[r][c] == 1 ) {
				r += dx[i];
				c += dy[i];
				cnt++;
				i = 0;
			}
		}
	}
}
