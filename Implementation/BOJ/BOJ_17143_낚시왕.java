/*
상어 객체를 2차원 배열에 담는다.

1. 열 한칸 이동
2. 해당 열 행이 제일 작은 상어 잡기
3. 새로운 맵에 상어 이동 (이동한 곳에 상어가 있다면 크기가 작은 상어는 사라짐) (벽을 만나면 반대 방향으로 이동) 
R-1로 나눈 몫이 0 || 짝수 : 반대 방향, 홀수 : 방향 그대로
R-1로 나눈 나머지만큼 이동

4. C 만큼 1-3반복

1 : 상
2 : 하
3 : 우
4 : 좌
*/
package com.ssafy.day1005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};
	static int R, C, M;
	static Shark[][] map, copyMap;
	static long ans = 0;
	public static class Shark {	// 상어객체
		int r;	// 상어의 x좌표
		int c;	// 상어의 y좌표
		int s;	// 상어의 속력
		int d;	// 상어의 이동 방향
		int z;	// 상어의 크기
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R + 1][C + 1];
		
		for (int i = 0; i < M; i++) {	// 상어 정보 입력받아서 map에 넣기
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
		}
		
		outline : for (int i = 1; i <= C; i++) {	// C만큼 낚시
			for (int j = 1; j <= R; j++) {	// 1행부터 탐색, 상어가 있으면 잡고 break
				if(map[j][i] != null) {
					ans += map[j][i].z;
					map[j][i] = null;
					break;
				}
			}
			move();
		}
		System.out.println(ans);
	}

	private static void move() {	// 상어 이동
		copyMap = new Shark[R + 1][C + 1];
		
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j] != null) {
					int r = map[i][j].r;
					int c = map[i][j].c;
					int s = map[i][j].s;
					int d = map[i][j].d;
					// 방향에 따라 이동 후 위치값, 방향 변경
					if(d == 1 || d == 2) {
						while(s > 0) {
							if(r + dx[d] <= 0 || r + dx[d] > R) {								
								if(d == 1) d = 2;
								else d = 1;
							}
							r += dx[d];
							s --;
						}
					} else if(d == 3 || d == 4) {
						while(s > 0) {
							if(c + dy[d] <= 0 || c + dy[d] > C) {								
								if(d == 3) d = 4;
								else d = 3;
							}
							c += dy[d];
							s --;
						}
					}
					if(copyMap[r][c] == null) copyMap[r][c] = new Shark(r, c, map[i][j].s, d, map[i][j].z);
					else {
						if(copyMap[r][c].z < map[i][j].z) copyMap[r][c] = new Shark(r, c, map[i][j].s, d, map[i][j].z);
					}
				}
			}
		}
		for (int i = 1; i <= R; i++) {
			map[i] = Arrays.copyOf(copyMap[i], C + 1);
		}
	}
}
