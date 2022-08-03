package com.ssafy.day0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1873_상호의배틀필드 {
	static String[][] map;
	static int r;
	static int c;
	static int h;
	static int w;
	static int head;
	static int[] dx = {-1, 1, 0, 0}; // 상 -> 하 -> 좌 -> 우
	static int[] dy = {0, 0, -1, 1}; // 상 -> 하 -> 좌 -> 우
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/1873.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String[] temp = br.readLine().split(" ");
			h = Integer.parseInt(temp[0]);	// 맵 높이
			w = Integer.parseInt(temp[1]);	// 맵 넓이
			map = new String[h][w];	// 게임 맵
			for (int i = 0; i < h; i++) {
				String[] str = br.readLine().split("");
				for (int j = 0; j < w; j++) {
					map[i][j] = str[j];
					if(map[i][j].equals("^") | map[i][j].equals(">") | map[i][j].equals("v") | map[i][j].equals("<")) {	// 시작 지점 찾기
						r = i;
						c = j;
					}
				}
			}
			int n = Integer.parseInt(br.readLine());	// 명령문 길이
			String[] arr = br.readLine().split("");	// 명령문 배열
			
			switch (map[r][c]) {
			case "^":
				head = 0;
				break;
			case "v":
				head = 1;
				break;
			case "<":
				head = 2;
				break;
			case ">":
				head = 3;
				break;
			}
			for (int i = 0; i < n; i++) {
				keyValue(arr[i]);
			}
			
			// 출력
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void keyValue(String key) {	// 키에 따라 이동방향 결정
		switch (key) {
		case "U":
			head = 0;
			battleField();
			break;
		case "D":
			head = 1;
			battleField();
			break;
		case "L":
			head = 2;
			battleField();
			break;
		case "R":
			head = 3;
			battleField();
			break;
		case "S":
			shoot();
			break;
		}
	}
	static void shoot() {	// #을 만나면 종료, *을 만나면 평지로 변경
		int i = r;
		int j = c;
		i += dx[head];
		j += dy[head];
		while(i >= 0 && i < h && j >= 0 && j < w) {
			if(map[i][j].equals("#") || map[i][j].equals("*")) {
				if(map[i][j].equals("#")) return;
				else {
					map[i][j] = "."; 
					break;
				}
			}
			i += dx[head];
			j += dy[head];
		}
	}

	static void battleField() {	// 이동 할 칸이 평지면 이동
		r += dx[head];
		c += dy[head];
		if(r >= 0 && r < h && c >= 0 && c < w) {
			if(!(map[r][c].equals("."))) {
				r -= dx[head];
				c -= dy[head];
			}else {
				map[r - dx[head]][c - dy[head]] = ".";
			}
		}else {
			r -= dx[head];
			c -= dy[head];
		}
		switch (head) {
		case 0:
			map[r][c] = "^";
			break;
		case 1:
			map[r][c] = "v";
			break;
		case 2:
			map[r][c] = "<";
			break;
		case 3:
			map[r][c] = ">";
			break;
		}
	}
}
