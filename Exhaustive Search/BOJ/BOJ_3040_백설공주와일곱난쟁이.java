package com.ssafy.day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int[] num;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		num = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0); // 조합
	}
	private static void comb(int r, int start) {
		if(r == num.length) {
			int sum = 0;
			for (int i = 0; i < num.length; i++) {
				sum += num[i];
			}
			if(sum == 100) {  // 만약 합이 딱 100이면 출력 후 종료 (재귀를 )
				for (int i = 0; i < num.length; i++) {					
					System.out.println(num[i]);
				}
				System.exit(0);
			}else return;
		}
		if(start == arr.length) return;
		num[r] = arr[start];
		comb(r + 1, start + 1);
		comb(r, start + 1);
	}
}
