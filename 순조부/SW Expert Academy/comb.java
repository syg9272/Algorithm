package com.ssafy.day0808;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("뽑을 개수 : ");
		n = sc.nextInt();
		int[] num = new int[n];
		comb(arr, num, 0, 0);
	}
	
	static void comb(int[] arr, int[] num, int r, int start) {
		if(r == n) {
			System.out.println(Arrays.toString(num));
			return;
		}
		if(start == arr.length) return;
		num[r] = arr[start];
		comb(arr, num, r + 1, start + 1);
		comb(arr, num, r, start + 1);
	}
}
