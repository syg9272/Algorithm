package com.ssafy.day0823;

import java.util.Arrays;
import java.util.Scanner;

public class 프림 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] input = new int[N][N];
		boolean[] check = new boolean[N];
		int[] minWeight = new int[N];
		Arrays.fill(minWeight, Integer.MAX_VALUE);
		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < N; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		// 시작점 아무거나 설정
		minWeight[0] = 0;
		int ans = 0;
		for (int i = 0; i < N; i++) {
			int minW = Integer.MAX_VALUE, minV = 0;
			// 최소가중치 갖는 것을 찾자 (내 편이 아닌)
			for (int j = 0; j < N; j++) {
				if(!check[j] && minWeight[j] < minW) {
					minW = minWeight[j];
					minV = j;
				}
			}
			ans += minW;
			// 내 편 만들자
			check[minV] = true;
			// 내 편이 갈 수 있는 간선에 대해서 최소값으로 갱신
			for (int j = 0; j < N; j++) {
				if(!check[j] && input[minV][j] != 0 && input[minV][j] < minWeight[j]) {
					minWeight[j] = input[minV][j];
				}
			}
		}
		System.out.println(ans);
	}
}
