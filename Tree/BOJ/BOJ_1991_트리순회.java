package com.ssafy.day0811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;
	
	public Node(char data) {
		this.data = data;
	}
}
public class BOJ_1991_트리순회 {
	static Node[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		char temp;
		int idx;
		tree = new Node[N];	// 노드를 남아놓은 트리
		for (int i = 0; i < N; i++) {	// 미리 노드객체 만들어놓기
			tree[i] = new Node((char) ('A' + i));
		}
		for (int i = 0; i < N; i++) {	// 해당 노드에 자식 달아주기
			st = new StringTokenizer(br.readLine(), " ");
			idx = st.nextToken().charAt(0) - 'A';
			
			temp = st.nextToken().charAt(0);	// 왼쪽 자식
			if(temp == '.') tree[idx].left = null;
			else tree[idx].left = tree[temp-'A'];
			
			temp = st.nextToken().charAt(0);	// 오른쪽 자식
			if(temp == '.') tree[idx].right = null;
			else tree[idx].right = tree[temp-'A'];
		}
		dfsByPreOrder(tree[0]);
		System.out.println();
		dfsByInOrder(tree[0]);
		System.out.println();
		dfsByPostOrder(tree[0]);
	}
	
	static void dfsByPreOrder(Node node) {	// 전위순회
		if(node == null) return;
		
		System.out.print(node.data);
		dfsByPreOrder(node.left);
		dfsByPreOrder(node.right);
	}
	static void dfsByInOrder(Node node) {	// 중위순회
		if(node == null) return;
		
		dfsByInOrder(node.left);
		System.out.print(node.data);
		dfsByInOrder(node.right);
	}
	static void dfsByPostOrder(Node node) {	// 후위순회
		if(node == null) return;
		
		dfsByPostOrder(node.left);
		dfsByPostOrder(node.right);
		System.out.print(node.data);
	}
}
