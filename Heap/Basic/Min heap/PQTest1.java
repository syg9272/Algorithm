package com.ssafy.day0812;

public class PQTest1 {
	public static void main(String[] args) {
		PQ1 pq = new PQ1();
		
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
