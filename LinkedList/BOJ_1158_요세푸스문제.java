package com.ssafy.day0808;

import java.util.Scanner;

class ListNode {
	int data;
	ListNode next;
	public ListNode() {
		this.data = 0;
		next = null;
	}
}
public class BOJ_1158_요세푸스문제 {
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		ListNode head = null;
		ListNode tail = null;
		int N = sc.nextInt();
		int K = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			ListNode temp = new ListNode();
			temp.data = i;
			if (i == 1) {
				head = temp;
				tail = temp;
				continue;
			}
			tail.next = temp;
			tail = temp;
		}
		tail.next = head;
		int i = 1;
		ListNode temp = null;
		temp = head;
		while(tail.data != tail.next.data) {
			if(i % K == 0) {
				sb.append(temp.data + ", ");
				tail.next = temp.next;
				temp = temp.next;
				
			}else {
				tail = tail.next;
				temp = temp.next;
			}
			i++;
		}
		sb.append(tail.data);
		sb.append(">");
		System.out.println(sb);
	}
}
