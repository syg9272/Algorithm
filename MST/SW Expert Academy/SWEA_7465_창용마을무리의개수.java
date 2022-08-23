package com.ssafy.day0823;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	static int[] p;
	static int N, M;
	private static void make() {
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
	private static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		
		p[b] = a;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			make();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if(p[i] == i) ans++;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
