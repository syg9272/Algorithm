package com.ssafy.day0812;

public class PQTest2 {
	public static void main(String[] args) {
		PQ2 pq = new PQ2();
		pq = new PQ2((n1, n2) -> n2 - n1);
		pq.offer(2);
		pq.offer(1);
		pq.offer(-8);
		pq.offer(-1);
		pq.offer(9);
		pq.offer(4);
		
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
	}
}
