package com.ssafy.day0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1220_Magnetic {
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String[][] map = new String[n][n];
			for (int j = 0; j < n; j++) {				
				map[j] = br.readLine().split(" ");
			}
			
			String temp = "";
			String[] arr;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				temp = "";
				for (int j = 0; j < n; j++) {		// 열마다 0으로 split 하면 자석만 남게 됨			
					temp += map[j][i];
				}
				arr = temp.split("0");
				check(arr);		// 자석만 남긴 뒤 check하러 가기
				sum += cnt;
			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
	
	static void check(String[] arr) {	// 남아있는 자석 개수 구하는 함수
		// 1. 길이가 1 이하면 남은 자석 0개
		// 2. 맨 앞이 2로 시작하면 그 뒤로 2일 때까지 전부 탈락
		// 3. 맨 뒤가 1로 끝나면 그 앞으로 1일 때까지 전부 탈락
		// 1,2,3을 거쳐온 arr -> "12"를 ""로 바꿔준뒤 길이의 차이를 계산 
		int i = 0;	// 앞에서부터 확인
		int j = arr.length - 1;	// 뒤에서 부터 확인
		if(arr.length <= 1) return;
		while(i < arr.length) {
			if(arr[i].equals("2")) {
				i++;
			}else break;
		}
		while(j > 0) {
			if(arr[j].equals("1")) {
				j--;
			}else break;
		}
		String temp = "";
		for (int k = i; k <= j; k++) {
			temp += arr[k];
		}
		String temp2 = temp.replaceAll("12", "");
		cnt = (temp.length() - temp2.length())/2;	// 12를 ""로 바꿨을 때 12는 2자리이지만 한 개로 보기 때문에 2로 나눠줘야 한다.
	}
}
