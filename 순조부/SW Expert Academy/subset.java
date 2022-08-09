package com.ssafy.day0808;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= arr.length; i++) {			
			int[] num = new int[i];
			subset(arr, num, 0, 0);
		}
	}
	
	static void subset(int[] arr, int[] num, int r, int start) {
		if(r == num.length) {
			System.out.println(num.length + "개 뽑을 때 : " + Arrays.toString(num));
			return;
		}
		if(start == arr.length) return;
		num[r] = arr[start];
		subset(arr, num, r + 1, start + 1);
		subset(arr, num, r, start + 1);
	}
}
