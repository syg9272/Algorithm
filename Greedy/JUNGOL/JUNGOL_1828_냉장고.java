package com.ssafy.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JUNGOL_1828_냉장고 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			map[i][0] = Integer.parseInt(temp[0]);
			map[i][1] = Integer.parseInt(temp[1]);			
		}
		Arrays.sort(map, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		int start = Integer.MIN_VALUE;
		int end = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if(map[i][0] >= start && map[i][0] <= end) {
				start = map[i][0];
				end = map[i][1] > end ? end : map[i][1];
			}else {
				start = map[i][0];
				end = map[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
