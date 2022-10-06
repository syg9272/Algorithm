package com.ssafy.day1006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];	// 수열의 원소들
			int[] LIS = new int[N];	// 동적 테이블 : 각 원소를 끝으로 하는 LIS값
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {	// 앞쪽부터 모든 원소기준으로 자신을 끝으로하는 LIS 계산
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
						LIS[i] = LIS[j] + 1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}
}
