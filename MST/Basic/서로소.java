package com.ssafy.day0823;

import java.util.Arrays;
import java.util.Scanner;

public class 서로소 {
	static int[] p;
	static int N, M;
	private static void make() {	// 집합 만들기
		p = new int[N];
		for (int i = 0; i < N; i++) {	// 본인이 대표가 되도록 만들기
			p[i] = i;
		}
	}
	private static int find(int a) {	// 부모 찾기
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	private static void union(int a, int b) {	// 집합 합치기
		a = find(a);
		b = find(b);
		if(a == b) return;
		
		p[b] = a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		make();
		for (int i = 0; i < M; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		System.out.println(Arrays.toString(p));
	}
}
