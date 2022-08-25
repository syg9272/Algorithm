package com.ssafy.day0825;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimPQ {
	
	static class Node {
		int vertex, weight;
		Node next;
		public Node(int vertex, int weight, Node next) {
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	static class Vertex implements Comparable<Vertex>{
		int no, weight;
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		Node[] adjList = new Node[V + 1];
		
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			// 무향 처리
			adjList[from] = new Node(to, weight, adjList[from]);
			adjList[to] = new Node(from, weight, adjList[to]);
		}
		
		int[] minEdge = new int[V + 1];	// 각 정점이 신장트리에 포함된 정점과의 간선 비용 중 최소비용
		boolean[] visited = new boolean[V + 1];	// 신장트리에 포함 여부
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); 	// 최소값 관리하기 위해 큰 값 세팅
		
		//1. 임의의 시작점 처리
		minEdge[1] = 0;
		int result = 0;	// 누적 가중치
		
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		pQueue.offer(new Vertex(1, minEdge[1]));
		
		int cnt = 0;	// 신장트리에 포함된 정점
		while (!pQueue.isEmpty()) {
      
			Vertex minVertex = pQueue.poll();
      
			// 포함한 정점이 또 나오면 무시
			if(visited[minVertex.no]) continue;
			
			//2. 선택된 곳 신장트리에 추가
			visited[minVertex.no] = true;
			//3. 누적 가중치 갱신
			result += minVertex.weight;
			
			if(++cnt == V) break;	// 모든 정점을 포함했다면 빠져나오기
			
			//4. 새로 추가된 정점의 모든 인접정점 들여다보며 처리
			for (Node temp = adjList[minVertex.no]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex] && minEdge[temp.vertex] > temp.weight) {
					minEdge[temp.vertex] = temp.weight;
					pQueue.offer(new Vertex(temp.vertex, minEdge[temp.vertex]));
				}
			}
		}
		System.out.println(result);
	}
}
