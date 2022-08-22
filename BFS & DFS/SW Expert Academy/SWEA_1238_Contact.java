package com.ssafy.day0822;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	static int[][] map;
	static List<Integer> list;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/1238.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			map = new int[101][101];
			boolean[] visited = new boolean[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
			}
			bfs(start, visited);
			sb.append("#" + t + " " + Collections.max(list) + "\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int start, boolean[] visited) {
		Queue<Integer> q = new ArrayDeque<>();
		list = new ArrayList<>();
		q.offer(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			boolean last = true;
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int now = q.poll();
				list.add(now);
				for (int i = 0; i < 101; i++) {
					if(!visited[i] && map[now][i] == 1) {
						visited[i] = true;
						last = false;
						q.offer(i);
					}
				}
			}
			if(!last) list = new ArrayList<>();
		}
	}
}
