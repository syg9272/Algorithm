/*
- 행을 기준으로 채워나가기 (81자리가 제일 작은 수를 먼저 찾기 위함)

1. 일단 1 ~ 9까지 오름차순으로 넣어보기
2. 겹치는지 체크 (행, 열, 사각형)
3. 칸을 다 채우면 그게 가장 작은 수 이므로 출력 후 종료 
*/
package com.ssafy.day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2239_스도쿠 {
	static int[][] map;
	public static void main(String[] args) throws Exception {
		map = new int[9][9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = c[j] - '0';
			}
		}
		sudoku(0, 0);
	}

	private static void sudoku(int r, int c) {
		if(r == 9) {	// 기저조건 : 출력 후 종료 (이게 81자리 제일 작은 수임)
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		if(map[r][c] != 0) {	// 만약 칸이 채워져있다면 다음 칸 찾기
			if(c + 1 == 9) sudoku(r + 1, 0);
			else sudoku(r, c + 1);
			return;
		} else {	// 비워져있다면 다음 큰 수 넣어보기			
			for (int i = 1; i <= 9; i++) {
				if(check(r, c, i)) {
					map[r][c] = i;
					if(c + 1 == 9) sudoku(r + 1, 0);
					else sudoku(r, c + 1);
					map[r][c] = 0;
				}
			}
			return;
		}
	}

	private static boolean check(int r, int c, int num) {
		// 행에서 유효한지 체크
		for (int j = 0; j < 9; j++) {
			if(map[r][j] == num) return false;
		}
		// 열에서 유효한지 체크
		for (int i = 0; i < 9; i++) {
			if(map[i][c] == num) return false;
		}
		// 사각형에서 유효한지 체크
		int x = (r / 3) * 3;
		int y = (c / 3) * 3;
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		return true;
	}
}
