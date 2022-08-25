/*
 * 입력받을 때 9면 거기가 시작지점
 * 
 * 1. 상어 < 물고기 ---> 못지나감
 * 2. 상어 == 물고기 --> 지나감
 * 3. 상어 > 물고기 ---> 먹음
 * 
 * 이동 우선순위 : 상 -> 좌 -> 우 -> 하
 * 
 * 물고기를 먹었을 때
 * 1. 큐 초기화
 * 2. 방문체크 초기화
 * 3. 상어 위치 초기화
 * 4. ans += time + 1
 * 5. time 초기화
 * 6. 새로운 시작위치 삽입
 * 	.
 * 	.
 * 	.
 * 필요한 변수
 * 1. 상어크기
 * 2. 큐에 넣을 int[] 배열 ({좌표(r, c), 먹은 생선 개수(fish), 이동한 시간(time)})
 * 3. 방문체크 boolean[][] 배열
 * 	.
 * 	.
 * 	.
 * 
 */
package com.ssafy.day0824;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int startX = 0;
		int startY = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					startX = i;
					startY = j;
				}
			}
		}
		
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0};
		
		int shark = 2;
		int ans = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> fishQ = new ArrayDeque<>();
		q.offer(new int[] {startX, startY, 0, 0});
		visited[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			int minH = N;
			int minW = N;
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = temp[0] + dx[d];
					int ny = temp[1] + dy[d];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] > shark) continue;
					if(map[nx][ny] == shark || map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, temp[2], temp[3] + 1});
					}
					else if (map[nx][ny] < shark) {
						minH = Math.min(minH, nx);
						fishQ.offer(new int[] {nx, ny, temp[2], temp[3]});
					}
				}
			}
			if(fishQ.size() == 0) continue;
			// 같은 거리에 여러마리의 물고기가 있을 경우 우선순위 높은 거 먹고 모든 상태 초기화
			int s = fishQ.size();
			for (int i = 0; i < s; i++) {					
				int[] num = fishQ.poll();
				if(num[0] == minH) {
					minW = Math.min(minW, num[1]);
					fishQ.offer(new int[] {num[0], num[1], num[2], num[3]});
				}
			}
			if(fishQ.size() > 1) {
				int s2 = fishQ.size();
				for (int i = 0; i < s2; i++) {					
					int[] num = fishQ.poll();
					if(num[1] == minW) {
						fishQ.offer(new int[] {num[0], num[1], num[2], num[3]});
					}
				}
			}
			int[] arr = fishQ.poll();
			map[arr[0]][arr[1]] = 9;
			map[startX][startY] = 0;
			startX = arr[0];
			startY = arr[1];
			visited = new boolean[N][N];
			visited[arr[0]][arr[1]] = true;
			ans += arr[3] + 1;
			q.clear();
			if(arr[2] + 1 == shark) {
				shark++;
				q.offer(new int[] {arr[0], arr[1], 0, 0});
			}else q.offer(new int[] {arr[0], arr[1], arr[2] + 1, 0});
		}
		System.out.println(ans);
	}
}
