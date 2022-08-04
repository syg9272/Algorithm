package com.ssafy.day0804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("data/1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			Stack<String> stack = new Stack<>();
			int l;
			int r;
			int result = 1;
			for (int i = 0; i < n; i++) {
				l = typeLeft(str[i]); // 여는 괄호 종류 알아오기 (닫는 괄호가 들어오면 5 반환) -> 이유 : 밑에서 4 이하인지 체크하기 때문에 4보다 큰 수 적용
				r = typeRight(str[i]);  //닫는 괄호 종류 알아오기 (여는 괄호가 들어오면 9 반환) -> 이유 : 아무것도 겹치치 않는 아무런 숫자 대입
				if(l <= 4) {  // 만약 여는 괄호가 들어왔다면
					stack.push(str[i]); // 스택에 추가
				}else { // 닫는 괄호가 들어왔다면
					if(typeLeft(stack.peek()) == r) stack.pop();  // 마지막으로 들어온 여는 괄호의 종류 받아와서 현재 들어온 닫는 괄호랑 세트일 때 여는 괄호 삭제
					else {  // 아니라면 결과는 유효하지 않음 -> result 0 으로 변경 후 종료
						result = 0; 
						break;
					}
				}
			}
			if(!(stack.empty())) result = 0;  // 만약 스택이 비어있지 않다면 닫는 괄호가 부족한 것 -> 결과 유효하지 않음
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	static int typeLeft(String str) { // 들어온 값이 여는 괄호일 경우 숫자 부여
		switch (str) {
		case "(":
			return 1;
		case "{":
			return 2;
		case "[":
			return 3;
		case "<":
			return 4;
		}
		return 5;
	}
	static int typeRight(String str) {  // 들어온 값이 닫는 괄호일 경우 여는 괄호에 맞게 숫자 부여
		switch (str) {
		case ")":
			return 1;
		case "}":
			return 2;
		case "]":
			return 3;
		case ">":
			return 4;
		}
		return 9;
	}
}
