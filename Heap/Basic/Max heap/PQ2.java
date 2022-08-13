package com.ssafy.day0812;

import java.util.Arrays;
import java.util.Comparator;

public class PQ2 {
	int[] elements;
	int pos;
	Comparator<Integer> comparator;
	
	public PQ2() {
		this(null);
	}
	
	public PQ2(Comparator<Integer> comparator) {
		elements = new int[10 + 1];
		this.comparator = comparator;
	}
	
	private boolean isFull() {
		return pos == elements.length - 1;
	}
	
	@Override
	public String toString() {
		if (pos == 0) return "[]";
		StringBuilder sb = new StringBuilder("[");
		sb.append(elements[1]);
		if (pos == 1) return sb.append("]").toString();
		for (int i = 2; i <= pos; i++) {
			sb.append(", " + elements[i]);
		}
		return sb.toString();
	}

	public void offer(int data) {
		if(isFull()) {
			increase();
		}
		elements[++pos] = data;
		int idx = pos;
		while(idx > 1 && isSwap(idx / 2, idx)) {	// 루트가 아닐 때 스왑
			swap(idx / 2, idx);
			idx /= 2;
		}
	}

	private void swap(int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}

	private boolean isSwap(int i, int j) {
		if(comparator != null) {
			return comparator.compare(elements[i], elements[j]) >= 1;
		}
		return elements[i] > elements[j];
	}

	private void increase() {
		elements = Arrays.copyOf(elements, elements.length * 2);
	}

	public int poll() {
		if(pos == 0) return 0;
		int result = elements[1];
		
		elements[1] = elements[pos];
		elements[pos--] = 0;
		heapify();	// heap 재정렬
		
		return result;
	}

	private void heapify() {
		int idx = 1;
		while(idx * 2 <= pos) { 	// 자식이 존재하는 여부
			if(pos >= idx * 2 + 1)	{// 오른쪽 자식 존재 여부
				if(!(isSwap(idx, idx * 2)) && !(isSwap(idx, idx * 2 + 1))) break;
			} else {
				if(!(isSwap(idx, idx * 2))) break;
			}
			int changeIdx = idx * 2;
			if(pos >= idx * 2 + 1) {
				changeIdx = isSwap(idx * 2, idx * 2 + 1) ? idx * 2 + 1 : idx * 2;
			}
			swap(idx, changeIdx);
			idx = changeIdx;
		}
	}

//	private boolean isEmpty() {
//		if(pos)
//		return false;
//	}
}
