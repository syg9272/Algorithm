/*
 * 완 전 탐 색 ...
 * 
 * 1. 도시 정보 입력받기
 * 2. 입력 받으면서 집 개수 저장
 * 3. k범위 설정 ----> 1 ~ 2N-1
 * 4. 모든 위치에서 k범위 안에 있는 집 개수 구하기 (최대 집 개수 저장) (|r - x| + |c - y| < k)
 * 5. 최대 집 개수에 대해 손익 계산
 * 6. 이익이 났을 때 최대 집 개수 저장
 * 7. 최대 집 개수가 총 집 개수와 같으면 종료 후 출력
 * 
 */
package study.day0825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2117_홈방범서비스 {	// 메모리 : 26692 kb	실행시간 : 456ms
	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("data/2117.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int homeCnt = 0;
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
					if(map[i][j] == 1) homeCnt++;
				}
			}
			int maxHome;
			int ans = 0;
			for (int k = 1; k <= (2 * N) - 1; k++) {
				maxHome = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						maxHome = Math.max(maxHome, security(i, j, k));
					}
				}
				if((maxHome * M) - ((k * k) + ((k - 1) * (k - 1))) < 0) continue;
				ans = Math.max(ans, maxHome);
				if(ans == homeCnt) break;
			}
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	private static int security(int r, int c, int k) {
		int home = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(Math.abs(r - i) + Math.abs(c - j) < k && map[i][j] == 1) home++;
			}
		}
		return home;
	}
}
