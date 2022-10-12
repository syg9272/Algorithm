package study.with.minhwan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {
	static int N, M, K, ans;
	static boolean[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			if(K == 1) sb.append(1 + "\n");
			else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(map[i][j]) {
							ans++;
							map[i][j] = false;
							bfs(i, j);
						}
					}
				}
				sb.append(ans + "\n");
			}
		}
		System.out.println(sb);
	}
	private static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int[] temp = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = temp[0] + dx[d];
					int nc = temp[1] + dy[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || !map[nr][nc]) continue;
					q.offer(new int[] {nr, nc});
					map[nr][nc] = false;
				}
			}
		}
	}
}
