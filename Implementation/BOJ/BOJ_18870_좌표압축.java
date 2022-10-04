package com.ssafy.day1004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_18870_좌표압축 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			map.put(num, 1);
		}
		int[] idx = new int[map.size()];
		int index = 0;
		for (Integer i : map.keySet()) {
			idx[index++] = i;
		}
		Arrays.sort(idx);
		for (int i = 0; i < idx.length; i++) {
			map.put(idx[i], i);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = map.get(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}
}
