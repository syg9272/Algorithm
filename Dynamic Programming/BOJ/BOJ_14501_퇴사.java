package study.with.minhwan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static int N, ans = Integer.MIN_VALUE;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		work(0, 0);
		System.out.println(ans);
	}

	private static void work(int day, int sum) {
		if(day >= N) {
			ans = Math.max(ans, sum);
			return;
		}
		if(day + arr[day][0] <= N) work(day + arr[day][0], sum + arr[day][1]);
		work(day + 1, sum);
	}
}
