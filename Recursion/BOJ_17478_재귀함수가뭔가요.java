package com.ssafy.recur;

import java.util.Scanner;

public class BOJ_17478_재귀함수가뭔가요 {
	static String result = "";
	static String str = "";
	static String str1 = "\"재귀함수가 뭔가요?\"\n";
	static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String[] temp = {str1, str2, str3, str4};
	
	static int depth = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		answer(n, depth);
	}
	
	static void answer(int n, int depth) {
		if(depth == n) {
			strStr3(depth);
			return;
		}
		setStr(depth);
		answer(n, depth+1);
		setStr2(depth);
		
	}

	static void strStr3(int depth) {
		str = "";
		for (int i = 0; i < depth*4; i++) {
			str += "_";
		}
		System.out.print(str + "\"재귀함수가 뭔가요?\"\n");
		System.out.print(str + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		System.out.print(str + "라고 답변하였지.\n");
		
	}

	static void setStr(int depth) {
		str = "";
		for (int i = 0; i < depth*4; i++) {
			str += "_";
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.print(str + temp[i]);
		}
	}
	static void setStr2(int depth) {
		str = "";
		for (int i = 0; i < depth*4; i++) {
			str += "_";
		}
		System.out.print(str + "라고 답변하였지.\n");
	}
}
