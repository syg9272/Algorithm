package com.ssafy.day0819;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1247_최적경로 {
	static int[][] map;
	static int[] num;
	static int N;
	static int minRoute;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			minRoute = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][2];
			num = new int[N + 2];
			num[0] = 0; num[N + 1] = 1;
			String[] temp = br.readLine().split(" ");
			for (int i = 0; i < N + 2; i++) {
				map[i][0] = Integer.parseInt(temp[i*2]);
				map[i][1] = Integer.parseInt(temp[i*2 + 1]);
			}
			boolean[] isSelected = new boolean[N+2];
			route(1, isSelected);
			sb.append("#" + t + " " + minRoute + "\n");
		}
		System.out.println(sb);
	}
	private static void route(int r, boolean[] isSelected) {
		if(r == N + 1) {
			minRoute = Math.min(minRoute, sum());
			return;
		}
		
		for (int i = 2; i < map.length; i++) {
			if(isSelected[i]) continue;
			num[r] = i;
			isSelected[i] = true;
			route(r + 1, isSelected);
			isSelected[i] = false;
		}
	}
	private static int sum() {
		int sum = 0;
		for (int i = 0; i < num.length - 1; i++) {
			sum += Math.abs(map[num[i]][0] - map[num[i + 1]][0]) + Math.abs(map[num[i]][1] - map[num[i + 1]][1]);
		}
		return sum;
	}
}
