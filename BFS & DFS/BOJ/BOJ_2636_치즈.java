/*
bfs

1. 치즈 개수 저장
2.치즈에 있는 구멍 찾기
2-1. 각 테두리에 있는 0에서 bfs로 방문체크하기
2-2. 전부 체크한 뒤에는 방문하지 않은 곳에서 방문한 곳과 만나는 곳을 원본에서 지우기
3. 원본에서 테두리 지우기

4. 1 - 3 반복
5. 치즈가 없어지는 시간, 저장해놓은 치즈 개수 출력
*/
package com.ssafy.day1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636_치즈 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int sum = 0;
		int cnt = 0;
		int time = 0;
		
		while(true) {
			// 치즈 개수 저장 & 출력값 저장
			sum = count();
			if(sum == 0) break;
			else cnt = sum;
			
			visited = new boolean[N][M];
			
			for (int j = 0; j < M; j++) {	// 가로 테두리
				if(map[0][j] == 0 && !visited[0][j]) findHole(0, j);
				if(map[N - 1][j] == 0 && !visited[N - 1][j]) findHole(N - 1, j);
			}
			for (int i = 0; i < N; i++) {	// 세로 테두리
				if(map[i][0] == 0 && !visited[i][0]) findHole(i, 0);
				if(map[i][M - 1] == 0 && !visited[i][M - 1]) findHole(i, M - 1);
			}
			
			// 방문체크되지 않은 곳 (치즈) 과 방문체크 된 곳이 만나는 지점 지우기
			remove();
			
			// 시간 증가 
			time++;
		}
		
		System.out.println(time + "\n" + cnt);
		
	}
	private static void remove() {	// 구멍뚫린 치즈 없애는 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j]) continue;
				for (int d = 0; d < 4; d++) {
					int x = i + dx[d];
					int y = j + dy[d];
					if(x < 0 || x >= N || y < 0 || y >= M || !visited[x][y]) continue;
					map[i][j] = 0;
				}
			}
		}
	}
	private static void findHole(int r, int c) {	// 테두리와 연결된 0 체크하는 함수
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = temp[0] + dx[d];
					int nc = temp[1] + dy[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] != 0) continue;
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
		
	}
	private static int count() {	// 치즈 개수 세는 함수
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) sum++;
			}
		}
		return sum;
	}
}
