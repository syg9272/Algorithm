package com.ssafy.day0804;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164_카드2 {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		int i = 1;
		while(q.size() > 1) {
			if(i % 2 == 1) {  // 홀수 번 째에서는 카드 버리기
				q.remove();
			}else { // 짝수 번 째에서는 뒤로 옮기기
				int temp = q.peek();
				q.remove();
				q.offer(temp);
			}
			i++;
		}
		System.out.println(q.peek());
	}
}
