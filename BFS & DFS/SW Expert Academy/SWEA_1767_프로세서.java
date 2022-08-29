/*
 * core위치 저장한 뒤 dfs로 4방탐색해서 최대 개수일 때 최소합 찾기
 * 
 * 해당 방향에 core와 전선이 없을 경우
 * --> 해당 방향 끝까지 방문체크 해주기 -> 재귀 호출 -> 돌아왔을 때 방문체크 해제
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N, maxCnt, ans;
	static int[][] map;
	static ArrayList<int[]> list;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			maxCnt = Integer.MIN_VALUE;
			map = new int[N][N];
			visited = new boolean[N][N];
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) list.add(new int[] {i, j});	// core위치 저장
				}
			}
			ans = 0;
			for (int i = 0; i < list.size(); i++) {	// 테두리에 있는 core 방문체크, 개수 추가
				if(list.get(i)[0] == 0 || list.get(i)[0] == N - 1 || 
						list.get(i)[1] == 0 || list.get(i)[1] == N - 1) {
					visited[list.get(i)[0]][list.get(i)[1]] = true;
				}
			}
			
			dfs(0, 0);	// dfs 호출
			
			sb.append("#" + t + " " + ans + " \n");
		}
		System.out.println(sb);
	}
	private static void dfs(int idx, int cnt) {
		if(idx == list.size()) {	// 모든 core 확인한 경우
			int sum = 0;
			if(maxCnt == cnt) {	// 이미 최대 개수의 core가 앞에서 저장되었으면 전선개수만 비교해서 저장
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(visited[i][j] && map[i][j] == 0) sum++;
					}
				}
				ans = Math.min(ans, sum);
			}else {	// 최대 개수가 앞에서 나타나지 않았을 경우 최대개수 core 갱신, 그때의 전선 수 저장
				maxCnt = Math.max(maxCnt, cnt);
				if(cnt == maxCnt) {
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if(visited[i][j] && map[i][j] == 0) sum++;
						}
					}
					ans = sum;
				}
			}
			return;
		}
		int r = list.get(idx)[0];
		int c = list.get(idx)[1];
		
		if(visited[r][c]) dfs(idx + 1, cnt + 1);	// 테두리에 있는 core는 무시(이미 체크 완료)
		else {
			outline : for (int d = 0; d < 4; d++) {	// 4방탐색
				int nr = r + dx[d];
				int nc = c + dy[d];
				while(nr >= 0 && nr < N && nc >= 0 && nc < N) {	// 범위가 유효할 때까지 해당 방향 확인
					if(visited[nr][nc] || map[nr][nc] == 1) {	// 만약 core나 전선이 있으면 다른 방향 탐색
						continue outline;
					}
					nr += dx[d];
					nc += dy[d];
				}
				nr = r + dx[d];
				nc = c + dy[d];
				while(nr >= 0 && nr < N && nc >= 0 && nc < N) {	// 장애물이 없으면 해당 방향 방문체크
					visited[nr][nc] = true;
					nr += dx[d];
					nc += dy[d];
				}
				
				dfs(idx + 1, cnt + 1);	// 재귀 호출
				
				nr = r + dx[d];
				nc = c + dy[d];
				while(nr >= 0 && nr < N && nc >= 0 && nc < N) {	// 돌아왔을 때 해당 방향 방문체크 해제
					visited[nr][nc] = false;
					nr += dx[d];
					nc += dy[d];
				}
			}
			dfs(idx + 1, cnt);
		}
	}
}
