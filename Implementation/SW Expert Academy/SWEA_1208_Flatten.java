package com.ssafy.recur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
	static int[] dump;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dump = new int[100];
		for (int test_case = 1; test_case <= 10; test_case++) {
			int cnt = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 100; j++) {	// 덤프 높이 받아오기
				dump[j] = Integer.parseInt(st.nextToken());				
			}
			while(cnt > 0) {
				dump[searchMax()]--;
				dump[searchMin()]++;
				cnt--;
			}
			System.out.println("#" + test_case + " " + (dump[searchMax()] - dump[searchMin()]));
		}
	}
	static int searchMax() {
		int maxNum = 1;
		int maxIdx = -1;
		for (int i = 0; i < 100; i++) {
			if(dump[i] > maxNum) {
				maxIdx = i;
				maxNum = dump[i];
			}
		}
		return maxIdx;
	}
	static int searchMin() {
		int minNum = 100;
		int minIdx = -1;
		for (int i = 0; i < 100; i++) {
			if(dump[i] < minNum) {
				minIdx = i;
				minNum = dump[i];
			}
		}
		return minIdx;
	}
}
