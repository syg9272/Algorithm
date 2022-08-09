package com.ssafy.day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_6808_규영이와인영이의카드게임 {
	static int[] arr;
	static int[] arr2;
	static int win;
	static int defeat;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			win = 0;
			defeat = 0;
			arr = new int[9];
			String[] temp = br.readLine().split(" ");
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(temp[i]);
			}
			arr2 = new int[9];
			outer : for (int i = 1, idx = 0; i <= 18; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[j] == i) continue outer;
				}
				arr2[idx++] = i;
			}
			boolean[] isSelected = new boolean[9];
			int[] num = new int[9];
			perm(num, isSelected, 0);
			sb.append("#" + test_case + " " + win + " " + defeat + "\n");
		}
		System.out.println(sb);
	}

	static void perm(int[] num, boolean[] isSelected, int r) {
		int sum = 0;
		int sum2 = 0;
		if(r == num.length) {
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] > num[i]) sum += arr[i] + num[i];
				else if(arr[i] < num[i]) sum2 += arr[i] + num[i];
			}
			if(sum > sum2) win ++;
			else if(sum < sum2) defeat++;
			return;
		}
		for (int i = 0; i < arr2.length; i++) {
			if(!(isSelected[i])) {
				num[r] = arr2[i];
				isSelected[i] = true;
				perm(num, isSelected, r + 1);
				isSelected[i] = false;
			}
			
		}
	}
}
