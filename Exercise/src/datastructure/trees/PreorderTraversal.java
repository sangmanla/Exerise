package datastructure.trees;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/tree-preorder-traversal/problem
 * @author sam
 *
 */
public class PreorderTraversal {
	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void preOrder(Node root) {
		if(root==null) return;
		
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		preOrder(root);
	}
}