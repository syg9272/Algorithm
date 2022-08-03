/*
 * ① 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
 * ② 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
 */
package com.ssafy.day0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SWEA_2805_농작물수확하기 {
	static int n;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		// 입력받기
		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < n; j++) {
					map[i][j] = c[j] - '0';
				}
			}
			int sum = 0;
			// 가운데 행에서 한 칸씩 멀어 질 때마다 harvesting 실행
			for (int gap = 0; gap <= n/2; gap++) {
				sum += harvesting(gap);
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
	static int harvesting(int gap) {
		int sum = 0;
		// 가운데 행은 갭이 0 이고 한 번만 더해야 함
		if(gap == 0) {
			for (int j = 0; j < n; j++) {				
				sum += map[n/2][j];
			}
		}else {	// 가운데 행에서 벌어진 갭에 따라 해당 행에서 열은 갭 ~ n-갭 까지 더해야함 (갭은 위 아래로 있으니 2번 더함)
			for (int j = gap; j < n - gap; j++) {
				sum += map[n/2 - gap][j];
				sum += map[n/2 + gap][j];
			}
		}
		return sum;
	}
}
