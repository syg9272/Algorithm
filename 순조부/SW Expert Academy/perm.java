package com.ssafy.day0808;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		boolean[] isSelected = new boolean[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("뽑을 개수 : ");
		n = sc.nextInt();
		int[] num = new int[n];
		perm(arr, num, isSelected, 0);
	}
	
	static void perm(int[] arr, int[] num, boolean[] isSelected, int r) {
		if(r == n) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!(isSelected[i])) {				
				num[r] = arr[i];
				isSelected[i] = true;
				perm(arr, num, isSelected, r + 1);
				isSelected[i] = false;
			}
			
		}
	}
}
