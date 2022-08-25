package com.ssafy.day0825;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySortrTest {
	static int V, E;
	static Node[] adjList;
	static int[] inDegree;
	static class Node {
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		adjList = new Node[V + 1];	// 각 정점별 인접리스트
		inDegree = new int[V + 1];	// 정점별 진입차수
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			// 유향처리
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;	// 진입차수 증가
		}
		ArrayList<Integer> list = topologySort();
		if(list.size() == V) {	// 완성
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
		}else {
			System.out.println("cycle..");
		}
	}
	
	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();
		
		// 진입차수가 0인 정점 큐에 넣기
		for (int i = 1; i <= V; i++) {
			if(inDegree[i] == 0) q.offer(i);
		}
		
		//BFS
		while(!q.isEmpty()) {
			int cur = q.poll();
			list.add(cur);
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(--inDegree[temp.vertex] == 0) q.offer(temp.vertex);
			}
		}
		return list;
	}
}
