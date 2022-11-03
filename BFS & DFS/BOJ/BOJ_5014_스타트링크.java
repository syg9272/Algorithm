package study.with.minhwan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[F + U + 1];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {S, 0});
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			int[] temp = q.poll();
			if(temp[0] == G) {
				System.out.println(temp[1]);
				System.exit(0);
			}
			for (int i = 0; i < size; i++) {
				int up = temp[0] + U;
				int down = temp[0] - D;
				if(up <= F && !visited[up]) {
					q.offer(new int[] {up, temp[1] + 1});
					visited[up] = true;
				}
				if(down >= 1 && !visited[down]) {
					q.offer(new int[] {down, temp[1] + 1});
					visited[down] = true;
				}
			}
		}
		
		System.out.println("use the stairs");
	}
}
