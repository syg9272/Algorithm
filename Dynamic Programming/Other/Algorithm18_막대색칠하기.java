/*
 빨간색은 짝수 번째 길이에서 전전단계 노란색과 파란색의 합만큼 더해진다.
 
    노 		         파		        x				    2
 노    파  x	    노   파   x 	  빨				   5
노파  노파 빨	  노파 노파  빨  	노파 				15
.
.
.
n = (n-1) * 2 + (n-2)
 */
package com.ssafy.day0929;

public class Algorithm18_막대색칠하기 {
	public static void main(String[] args) {
		int n = 6;
		
		int[] color = new int[n + 1];
		
		color[1] = 2;
		color[2] = 5;
		
		for (int i = 3; i <= n; i++) {
			color[i] = color[i - 1] * 2 + color[i - 2];
		}
		
		System.out.println(color[n]);
	}
}
