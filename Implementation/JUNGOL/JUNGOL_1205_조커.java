package com.ssafy.day0809;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_1205_조커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int result = 0;
		int maxNum = 0;	// 배열 낭비를 막기 위해 boolean배열을 카드 최대 값까지만 생성
		int joker = 0;	// 조커 카드 개수
		for (int i = 0; i < N; i++) {	// 카드 입력 받기
			arr[i] = sc.nextInt();
			if(arr[i] == 0) joker++;
			maxNum = Math.max(maxNum, arr[i]);
		}
		boolean[] isNum = new boolean[maxNum+1];
		for (int i = 0; i < arr.length; i++) {	// 어떤 숫자가 담겼는지 확인할 용도
			isNum[arr[i]] = true;
		}
		int cnt;	// 최고길이 구하기
		int fail;
		for (int i = 1; i < isNum.length; i++) {
			cnt = 0;
			fail = joker;
			for (int j = i; j < isNum.length; j++) {	
				if(isNum[j]) {
					cnt++;
				}else if (fail > 0) {
					cnt++;
					fail--;
				}else break;
			}
			cnt += fail;
			result = Math.max(result, cnt);
		}
		if(isNum.length == 1) result = joker;
		System.out.println(result);
	}
}
