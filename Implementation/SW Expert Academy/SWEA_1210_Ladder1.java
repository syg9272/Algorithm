package com.ssafy.recur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	static int[][] map;
	static int r;
	static int c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/1210.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = Integer.parseInt(bf.readLine());
			
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			r = map.length - 1;
			c = -1;
			for (int i = 0; i < map.length; i++) {	// 도착지에서 출발
				if(map[map.length - 1][i] == 2) {
					c = i;
					break;
				}
			}
			start();
			System.out.println("#" + test_case + " " + c);
		}
	}
	
	static void start() {
		while(true) {
			if((c - 1) >= 0 && map[r][c - 1] != 0) {
				while((c - 1) >= 0 && map[r][c - 1] != 0) {
					c--;
				}
				r--;
			}else if((c + 1) < 100 && map[r][c + 1] != 0) {
				while((c + 1) < 100 && map[r][c + 1] != 0) {
					c++;
				}
				r--;
			}else if((r - 1) >= 0){
				r--;
			}else break;
		}
	}
}
