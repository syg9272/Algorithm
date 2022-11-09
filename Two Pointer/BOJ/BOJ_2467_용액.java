package study.with.minhwan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N - 1;
		long ans = Integer.MAX_VALUE;
		long a = 0;
		long b = 0;
		while(left < right) {
			long mix = arr[left] + arr[right];
			if(Math.abs(0 - ans) > Math.abs(0 - mix)) {
				ans = Math.abs(0 - mix);
				a = arr[left];
				b = arr[right];
			}
			if(mix < 0) left++;
			else right --;
		}
		
		System.out.println(a + " " + b);
	}
}
