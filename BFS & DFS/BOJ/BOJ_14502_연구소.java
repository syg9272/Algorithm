/*
bfs + 조합

0 : 빈 칸
1 : 벽
2 : 바이러스

벽 3개 꼭 세우기

1. 0인 곳 좌표 list에 넣기
2. 거기서 3개 조합으로 뽑기
3. 조합 뽑으면 안전구역 최대인 곳 찾기 (bfs)
*/
package com.ssafy.day1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][] map;
	static int N, M;
	static int[] idx = new int[3];
	static List<int[]> list;
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		// map입력 받으면서 0인 곳 좌표 list에 넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					list.add(new int[] {i, j});				
				}
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}
	private static void comb(int r, int start) {	// 벽 3개 조합 뽑기
		if(r == 3) {	// 벽 3개 조합 완성
			// 뽑은 위치에 벽세우기 -> bfs로 안전구역 구하기 & 최대값 갱신 -> map원래대로 돌려놓기
			for (int i = 0; i < idx.length; i++) {
				map[list.get(idx[i])[0]][list.get(idx[i])[1]] = 1;
			}
			bfs();
			for (int i = 0; i < idx.length; i++) {
				map[list.get(idx[i])[0]][list.get(idx[i])[1]] = 0;
			}
			return;
		}
		if(start == list.size()) return;
		idx[r] = start;
		comb(r + 1, start + 1);
		comb(r, start + 1);
		
	}
	private static void bfs() {
		int sum = 0;
		
		// bfs에 사용하기 위해 맵 복사하기
		int[][] mapCopy = new int[N][M];
		for (int i = 0; i < N; i++) {
			mapCopy[i] = Arrays.copyOf(map[i], M);
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		// 처음 바이러스 좌표 q에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mapCopy[i][j] == 2) q.offer(new int[] {i, j});
			}
		}
		// 바이러스 옮기기
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = temp[0] + dx[d];
					int nc = temp[1] + dy[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || mapCopy[nr][nc] != 0) continue;
					mapCopy[nr][nc] = 2;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		// 다 옮긴 뒤에 빈 칸 개수 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(mapCopy[i][j] == 0) sum++;
			}
		}
		// 안전구역 최대값 갱신
		ans = Math.max(ans, sum);
	}
}
