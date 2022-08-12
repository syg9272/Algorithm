package com.ssafy.day0812;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4012_요리사 {
	static int[][] map;
	static int[] num;
	static int minSum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			minSum = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			num = new int[N/2];
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < map.length; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}
			comb(0, 0);
			sb.append("#" + test_case + " " + minSum + "\n");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void comb(int r, int start) {
		if(r == num.length) {
			int[] num2 = new int[map.length/2];
			outline : for (int i = 0, idx = 0; i < map.length; i++) {
				for (int j = 0; j < num.length; j++) {
					if(i == num[j]) continue outline; 
				}
				num2[idx++] = i; 
			}
			minSum = Math.min(minSum, Math.abs(sum(num) - sum(num2))); 
			return;
		}
		if(start == map.length) return;
		
		num[r] = start;
		comb(r + 1, start + 1);
		comb(r, start + 1);
	}
	private static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i != j) sum += map[arr[i]][arr[j]];
			}
		}
		return sum;
	}
}
