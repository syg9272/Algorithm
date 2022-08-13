package com.ssafy.day0812;

import java.util.PriorityQueue;

public class PQTest {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		
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
		
		PriorityQueue<Student> pq2 = new PriorityQueue<>();
		pq2 = new PriorityQueue<>((o1, o2) -> o2.no - o1.no);
		pq2.offer(new Student(10, "서예지"));
		pq2.offer(new Student(30, "조재형"));
		pq2.offer(new Student(20, "김민식"));
		pq2.offer(new Student(40, "안효관"));
		
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		
//		pq2 = (() ->);
	}
	static class Student implements Comparable<Student>{
		int no;
		String name;
		public Student(int no, String name) {
			this.no = no;
			this.name = name;
		}
		@Override
		public int compareTo(Student o) {
			return this.no - o.no;
		}
		@Override
		public String toString() {
			return "Student [no=" + no + ", name=" + name + "]";
		}
		
	}
}
