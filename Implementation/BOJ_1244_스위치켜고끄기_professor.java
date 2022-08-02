package com.ssafy.recur;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BOJ_1244_스위치켜고끄기_교수님 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("data/1244.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//스위치 개수
		int[] data = new int[N + 1];	//스위치 번호 맞추기 위해
		for (int i = 1; i <= N; i++) {	//스위치 상태 받아오기
			data[i] = sc.nextInt();
		}
		int stuNum = sc.nextInt();	//학생 수
		int loc = 0;	//스위치 위치 값
		int[] change = {1, 0};	//스위치 상태 바꾸기 위한 배열
		for (int i = 0; i < stuNum; i++) {	//학생 정보 받기
			switch (sc.nextInt()) {
			case 1:	//남학생
				loc = sc.nextInt();
				for (int j = loc; j <= N; j += loc) {
					data[j] = change[data[j]];
				}
				break;
			case 2:	//여학생
				loc = sc.nextInt();
				int l = loc, r = loc;	//왼쪽 오른쪽으로 이동할 위치
				while(l >= 1 && r <= N) {
					if(data[l] != data[r]) break;
					data[l] = data[r] = change[data[l]];
					l--; r++;
				}	
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.printf("%d%s", data[i], i % 20 == 0 ? "\n" : " ");
		}
		
		sc.close();
	}

}
