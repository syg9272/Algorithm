/*
몬스터 몇 번 까지 있는지
입력받으면서 위치값 저장(list에) --- 처음에 0, 0 넣어두기

입력 다 받으면
int[][] map = new int [list.size()][list.size()] --> 각 포인트와의 거리 미리 계산해서 넣어두기

list,get(0)은 시작지점 ,,, 
각 포인트와의 거리 계산해서 저장

순서 정하기 : 순열  ---> 음수 값 들어왔을 때 해당 고객 절대값 몬스터 제거 여부
구해진 모든 순서에 따라 최소경로 찾기

몬스터 1 -> 고객 -1
몬스터 2 -> 고객 -2
몬스터 3 -> 고객 -3
몬스터 4 -> 고객 -4
 */
package com.ssafy.practice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_No2_헌터 {	// 메모리 : 23980 kb	실행시간 : 156 ms
	static int ans;
	static int[] idx;
	static ArrayList<int[]> list;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			list.add(new int[] {0, 0, 0});
			
			for (int i = 0; i < N; i++) {	// 입력받으면서 몬스터, 고객이 있으면 list에 번호와 위치값 저장
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n > 0 || n < 0) list.add(new int[] {n, i, j});
				}
			}
			
			map = new int[list.size()][list.size()];
			int a;
			int b;
			for (int i = 0; i < list.size(); i++) {	// 각 포인트마다 거리 계산해서 저장
				for (int j = 0; j < list.size(); j++) {
					if(i == j) continue;
					
					if(list.get(i)[0] < 0) a = list.size() / 2 + Math.abs(list.get(i)[0]);
					else a = list.get(i)[0];
					
					if(list.get(j)[0] < 0) b = list.size() / 2 + Math.abs(list.get(j)[0]);
					else b = list.get(j)[0];
					
					map[a][b] = Math.abs(list.get(i)[1] - list.get(j)[1]) + Math.abs(list.get(i)[2] - list.get(j)[2]);
				}
			}
			
			boolean[] visited = new boolean[list.size()];
			idx = new int[list.size()];
			idx[0] = 0;
			perm(1, visited);
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	private static void perm(int r, boolean[] visited) {
		if(r == idx.length) {
			// 거리 합 계산 후 최소거리 갱신
			int sum = 0;
			for (int i = 0; i < idx.length - 1; i++) {
				sum += map[idx[i]][idx[i + 1]];
			}
			ans = Math.min(ans, sum);
			return;
		}
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[0] < 0) {
				if(!visited[Math.abs(list.get(i)[0])]) continue;
				if(visited[list.size() / 2 + Math.abs(list.get(i)[0])]) continue;
				
				idx[r] = list.size() / 2 + Math.abs(list.get(i)[0]);	//위치 넣기
				
				// 순열
				visited[list.size() / 2 + Math.abs(list.get(i)[0])] = true;
				perm(r + 1, visited);
				visited[list.size() / 2 + Math.abs(list.get(i)[0])] = false;
			}else {
				if(visited[list.get(i)[0]]) continue;
				
				idx[r] = list.get(i)[0];	// 위치 넣기
				
				// 순열
				visited[list.get(i)[0]] = true;
				perm(r + 1, visited);
				visited[list.get(i)[0]] = false;				
			}
		}
	}
}
