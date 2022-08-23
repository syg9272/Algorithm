package com.ssafy.day0823;

import java.util.Arrays;
import java.util.Scanner;

public class 크루스칼 {
	static int V, E;
	static Edge[] edgeList;
	static class Edge {
		int from, to, weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	static int[] p;
	private static void make() {
		p = new int[V];
		for (int i = 0; i < V; i++) {
			p[i] = i;
		}
	}
	private static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		
		p[b] = a;
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		edgeList = new Edge[E];
		for (int i = 0; i < E; i++) {
			edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);
		
		make();
		
		int ans = 0;	// 가중치 합
		int cnt = 0;	// 선택된 간선의 수
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				ans += edge.weight;
				if(++cnt == V - 1) break;
			}
		}
		
		System.out.println(ans);
	}
}
