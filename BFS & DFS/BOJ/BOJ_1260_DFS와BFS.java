package com.ssafy.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int[][] map;
	static int N, M, V;
	static StringBuilder sb;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		int to;
		int from;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			to = Integer.parseInt(st.nextToken());
			from = Integer.parseInt(st.nextToken());
			map[to][from] = map[from][to] = 1;
		}
		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs();
		System.out.println(sb);
	}
	private static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		
		for (int i = 1; i <= N; i++) {
			if(map[v][i] != 0 && !visited[i]) dfs(i);
		}
	}
	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		visited[V] = true;
		q.offer(V);
		while(!q.isEmpty()) {
			int n = q.poll();
			sb.append(n + " ");
			for (int i = 1; i <= N; i++) {
				if (map[n][i] != 0 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
