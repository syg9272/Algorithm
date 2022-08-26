/*
 * 공기정청기 1열 (2칸 차지)
 * 
 * 미세먼지 확산
 * 1. 4방확산 ----> 공기청정기가 있거나 미세먼지양이 5보다 작거나 인덱스 밖이면 continue
 * 2. 확산 양 : 현재 값/5 /// 남은 양 : 현재 값 -확산 양 * 방향 수
 * 
 * 공기청정기 작동 
 * 1. 위에 칸 기준 : 반시계방향 (우 -> 상 -> 좌 -> 하) ---> (상 -> 우 -> 하 ->좌)역방향으로 이동하면서 한 칸씩 당기기
 * 2. 아래 칸 기준 : 시계방향 (우 -> 하 -> 좌 -> 상)  ----> (하 -> 우 -> 상 -> 좌) 역방향으로 이동하면서 한 칸씩 당기기
 * 
 * 1. 공기청정기 위치 값 받기
 * 2. 미세먼지 위치값 큐에 넣기
 * 3. while문으로 미세먼지 확산 -> 공기청정기 작동
 * 4. 맵을 돌면서 0보다 큰 값을 다 더한 뒤 출력
 * 
 * Queue 에 넣을 int[] 배열 : new int[] {r, c, 미세먼지양(dust)}
 */

package com.ssafy.day0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지안녕 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		int airCleaner1 = -1;
		int airCleaner2 = -1;
		
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) continue;
				if(map[i][j] == -1) {
					if(airCleaner1 >= 0) continue;
					airCleaner1 = i;
					airCleaner2 = i + 1;
				}else q.offer(new int[] {i, j, map[i][j]});
			}
		}
		// 상 -> 우 -> 하 ->좌
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		// 하 -> 우 -> 상 -> 좌
		int[] dx2 = {1, 0, -1, 0};
		int[] dy2 = {0, 1, 0, -1};
		
		
		while(!q.isEmpty()) {
			int size = q.size();
			// 미세먼지 확산
			if(T == 0) break;
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = temp[0] + dx[d];
					int ny = temp[1] + dy[d];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || map[nx][ny] == -1 || temp[2] < 5) continue;
					else {
						cnt++;
						map[nx][ny] += temp[2] / 5;
					}
				}
				map[temp[0]][temp[1]] -= (temp[2] / 5) * cnt;
			}
			// 공기청정기
			int nx = airCleaner1 - 1;
			int ny = 0;
			int nx2 = airCleaner2 + 1;
			int ny2 = 0;
			for (int d = 0; d < 4; d++) {
				nx += dx[d];
				ny += dy[d];
				nx2 += dx2[d];
				ny2 += dy2[d];
				while(nx >= 0 && nx <= airCleaner1 && ny >= 0 && ny < C) {
					if(map[nx][ny] == -1) {
						map[nx - dx[d]][ny - dy[d]] = 0;
						break;
					}
					map[nx - dx[d]][ny - dy[d]] = map[nx][ny];
					nx += dx[d];
					ny += dy[d];
				}
				while(nx2 >= airCleaner2 && nx2 < R && ny2 >= 0 && ny2 < C) {
					if(map[nx2][ny2] == -1) {
						map[nx2 - dx2[d]][ny2 - dy2[d]] = 0;
						break;
					}
					map[nx2 - dx2[d]][ny2 - dy2[d]] = map[nx2][ny2];
					nx2 += dx2[d];
					ny2 += dy2[d];
				}
				if(d != 3) {						
					nx -= dx[d];
					ny -= dy[d];
					map[nx][ny] = map[nx + dx[d + 1]][ny + dy[d + 1]];
					
					nx2 -= dx2[d];
					ny2 -= dy2[d];
					map[nx2][ny2] = map[nx2 + dx2[d + 1]][ny2 + dy2[d + 1]];
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] > 0) q.offer(new int[] {i, j, map[i][j]});
				}
			}
			T--;
		}
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) ans += map[i][j]; 
			}
		}
		System.out.println(ans);
	}
}
