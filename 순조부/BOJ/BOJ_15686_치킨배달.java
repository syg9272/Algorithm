package com.ssafy.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15686_치킨배달 {
	static int[][] map;
	static int[][] home;
	static int[][] chicken;
	static int[][] num;
	static int idx;
	static int idx2;
	static int result = Integer.MAX_VALUE;
	static int minLen;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		num = new int[M][2];
		map = new int[N][N];
		home = new int[2 * N][2];
		chicken = new int[13][2];
		idx = 0;
		idx2 = 0;
		for (int i = 0; i < N; i++) {
			temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				if(map[i][j] == 1) {
					home[idx][0] = i;
					home[idx++][1] = j;
				}
				if(map[i][j] == 2) {
					chicken[idx2][0] = i;
					chicken[idx2++][1] = j;					
				}
			}
		}
		comb(0, 0);
		System.out.println(result);
	}
	private static void comb(int r, int start) {
		if(r == num.length) {
			int sum = 0;
			for (int i = 0; i < idx; i++) {
				minLen = Integer.MAX_VALUE;
				for (int j = 0; j < num.length; j++) {
					minLen = Math.min(minLen, Math.abs(home[i][0] - num[j][0]) + Math.abs(home[i][1] - num[j][1]));
				}
				sum += minLen;
			}
			result = Math.min(result, sum);
			return;
		}
		if(start == idx2) return;
		num[r][0] = chicken[start][0];
		num[r][1] = chicken[start][1];
		comb(r + 1, start + 1);
		comb(r, start + 1);
	}
}
