package com.ssafy.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	static int num;
	static int ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N > K) {
			System.out.println(N - K);
		}else {
			num = K;
			visited = new boolean[100001];
			hideNseek(N, visited);
			System.out.println(ans);
		}
	}
	private static void hideNseek(int n, boolean[] visited) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(n);
		q.add(0);
		visited[n] = true;
		while(!q.isEmpty()) {
			int v = q.poll();
			int t = q.poll();
			if(v == num) {
				ans = t;
				break;
			}
			if(v * 2 < visited.length && !visited[v * 2]) {
				visited[v * 2] = true;
				q.offer(v * 2);
				q.offer(t + 1);
			}
			if(v + 1 < visited.length && !visited[v + 1]) {
				visited[v + 1] = true;
				q.offer(v + 1);
				q.offer(t + 1);
			}
			if(v - 1 >= 0 && !visited[v - 1]) {
				visited[v - 1] = true;
				q.offer(v - 1);
				q.offer(t + 1);
			}
		}
	}
}
