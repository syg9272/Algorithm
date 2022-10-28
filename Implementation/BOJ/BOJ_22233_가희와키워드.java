package study.day1027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_22233_가희와키워드 {	// 메모리 : 325,928 kb		실행시간 : 1,356 ms
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<String> list = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		int ans = list.size();
		HashSet<String> hSet = new HashSet<>();
		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().split(",");
			for (int j = 0; j < temp.length; j++) {
				if(!list.add(temp[j]) && hSet.add(temp[j])) {
					ans--;
				}
				else list.remove(temp[j]);
			}
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}
