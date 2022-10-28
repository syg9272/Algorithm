package study.with.minhwan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {	// 메모리 : 158,100 kb		실행시간 : 644 ms
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) q.offer(new int[] {i, j, 0});
			}
		}
		
		boolean[][] island = new boolean[N][M];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = temp[0] + dx[d];
					int nc = temp[1] + dy[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] > 0) continue;
					cnt++;
				}
				q.offer(new int[] {temp[0], temp[1], cnt});
			}
			int size2 = q.size();
			for (int i = 0; i < size2; i++) {
				int[] temp2 = q.poll();
				map[temp2[0]][temp2[1]] -= temp2[2];
				if(map[temp2[0]][temp2[1]] > 0) {
					q.offer(new int[] {temp2[0], temp2[1], 0});
					island[temp2[0]][temp2[1]] = true;
				}
			}
			int cnt2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] <= 0 || !island[i][j]) continue;
					Queue<int[]> q2 = new ArrayDeque<>();
					q2.offer(new int[] {i, j});
					island[i][j] = false;
					while(!q2.isEmpty()) {
						int len = q2.size();
						for (int k = 0; k < len; k++) {
							int[] temp = q2.poll();
							for (int d = 0; d < 4; d++) {
								int nr = temp[0] + dx[d];
								int nc = temp[1] + dy[d];
								if(nr < 0 || nr >= N || nc < 0 || nc >= M || !island[nr][nc]) continue;
								island[nr][nc] = false;
								q2.offer(new int[] {nr, nc});
							}
						}
					}
					cnt2++;
				}
			}
			time++;
			if(cnt2 >= 2) {
				System.out.println(time);
				System.exit(0);
			}
		}
		System.out.println(0);
	}
}
