package com.ssafy.day0804;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int t = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				q.add(sc.nextInt());
			}
			int i = 1;
			while(true) { 
				if(i == 6) i = 1; // 빼는 수가 1~5까지 반복이므로 6이되면 다시 1로 복귀
				if(q.peek() - i <= 0) { // 만약 첫 번째에서 i를 뺄 때 0이하가 되면 0을 맨 뒤로 보내고 종료 
					q.add(0);
					q.remove();
					break;
				}
				q.add(q.poll()-i);  // 빼도 0 이하가 되지 않으면 i만큼 뺴고 뒤로 보내기
				i++;
			}
			sb.append("#" + test_case + " ");
			for (int j = 0; j < 8; j++) {
				sb.append(q.poll() + " ");
			}
			sb.append("\n");
			q.clear();
		}
		System.out.println(sb);
	}
}
