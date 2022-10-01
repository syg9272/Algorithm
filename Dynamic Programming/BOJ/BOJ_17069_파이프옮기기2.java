/*
 * dp[r][c][0] : 가로 방향
 * dp[r][c][1] : 세로 방향
 * dp[r][c][2] : 대각선 방향
 * 
 * 파이프 방향을 나타냄과 동시에 현 위치까지 온 경우의 수를 방향별로 메모하며 도착지점까지 이동
 */
package com.ssafy.day0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069_파이프옮기기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N + 1][N + 1];
		long[][][] dp = new long[N + 1][N + 1][3];
		
		for (int i = 1; i <= N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(temp[j - 1]);
			}
		}
		
		// 처음 파이프가 가로로 놓여있기 때문에 가능한 방향은 가로, 대각선
		dp[1][2][0] = 1;
		dp[1][2][2] = 1;
		
		// 결과 저장할 변수 (단위를 조심하자)
		long ans = 0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 3; j <= N; j++) {
				// 현재 위치가 벽이라면 무시
				if(map[i][j] == 1) continue;
				// 도착지에 도착하면 모든 방향에 대해 메모해놓은 경로 합 저장
				if(i == N && j == N) {
					ans += dp[i][j - 1][0];
					ans += dp[i - 1][j][1];
					if(map[i - 1][j] == 0 && map[i][j - 1] == 0)ans += dp[i - 1][j - 1][2];
					break;
				}
				// 대각선으로 도착한 경우 가능한 진행 방향 : 가로, 세로, 대각선
				if(dp[i - 1][j - 1][2] > 0) {
					if(map[i - 1][j] == 0 && map[i][j - 1] == 0) {						
						if(j + 1 <= N && map[i][j + 1] == 0) dp[i][j][0] += dp[i - 1][j - 1][2];
						if(i + 1 <= N && map[i + 1][j] == 0) dp[i][j][1] += dp[i - 1][j - 1][2];
						if(i + 1 <= N && j + 1 <= N && map[i + 1][j + 1] == 0) dp[i][j][2] += dp[i - 1][j - 1][2];
					}
				}
				// 가로로 도착한 경우 가능한 진행 방향 : 가로, 대각선
				if(dp[i][j - 1][0] > 0) {
					if(j + 1 <= N && map[i][j + 1] == 0) dp[i][j][0] += dp[i][j - 1][0];
					if(i + 1 <= N && j + 1 <= N && map[i + 1][j + 1] == 0) dp[i][j][2] += dp[i][j - 1][0];
				}
				// 세로로 도착한 경우 가능한 진행 방향 : 세로, 대각선
				if(dp[i - 1][j][1] > 0) {
					if(i + 1 <= N && map[i + 1][j] == 0) dp[i][j][1] += dp[i - 1][j][1];
					if(i + 1 <= N && j + 1 <= N && map[i + 1][j + 1] == 0) dp[i][j][2] += dp[i - 1][j][1];
				}
			}
		}
		// 결과 출력
		System.out.println(ans);
	}
}
