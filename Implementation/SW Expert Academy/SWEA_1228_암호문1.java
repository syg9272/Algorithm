package com.ssafy.day0808;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class SWEA_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			ArrayList<String> list = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int idx;
			int m;
			for (int i = 0; i < N; i++) {
				if(st.nextToken().equals("I")) {
					idx = Integer.parseInt(st.nextToken());
					m = Integer.parseInt(st.nextToken());
					for (int j = 0; j < m; j++) {
						list.add(idx, st.nextToken());
						idx++;
					}
				}
			}
			sb.append("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {				
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
