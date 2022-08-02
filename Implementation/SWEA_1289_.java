package com.ssafy.recur;

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
	static int[] memory;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();	// 테스트 케이스 개수
		
		for (int test_case = 1; test_case <= t; test_case++) {
			// 메모리 받아오기
			String temp = sc.next();	//메모리 상태 문자열로 입력받기
			memory = new int[temp.length()];	//문자열 길이만큼 int배열 생성
			for (int i = 0; i < temp.length(); i++) {	//int배열에 메모리 bit 하나하나 넣기
				memory[i] = temp.charAt(i) - '0';
			}
			
			//뒤에서부터 같은 값일 때 까지 change (고른 자리부터 끝까지 덮어씌우기 때문에 뒤에서부터 확인)
			int[] change = {1, 0};
			int cnt = 0;
			while(true) {
				if(check()) break;	// 만약 원래 값으로 복구했다면 while문 빠져나가기
				int value = memory[memory.length-1];	//맨 마지막 bit 값을 저장 (이와 같은지 비교하기 위해)
				for (int i = memory.length-1; i >= 0; i--) {
					if(memory[i] != value) break;
					memory[i] = change[memory[i]];
				}
				cnt++;
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	static boolean check() {
		// 모든 bit가 0일 경우 true 반환
		for (int i = 0; i < memory.length; i++) {
			if(memory[i] == 1) return false;
		}
		return true;
	}
}
