package com.ssafy.day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
			else return Math.abs(o1) - Math.abs(o2);
		});
		int N = Integer.parseInt(br.readLine());
		int x;
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.size() == 0) sb.append(0 + "\n");
				else sb.append(pq.poll() + "\n");
			}
			else pq.offer(x);
		}
		System.out.println(sb);
	}
}
