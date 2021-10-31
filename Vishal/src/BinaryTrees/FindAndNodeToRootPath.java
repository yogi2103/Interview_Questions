package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

import BinaryTrees.Levelorder.Node;

public class FindAndNodeToRootPath {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static void printBinaryTree(Node root) {
		if (root == null)
			return;

		if (root.left != null)
			System.out.print(root.left.data + "-");
		else
			System.out.print("* -");

		System.out.print(" " + root.data + " ");

		if (root.right != null)
			System.out.println(" - " + root.right.data);
		else
			System.out.println("- *");

		printBinaryTree(root.left);
		printBinaryTree(root.right);

	}

	static class Pair {
		Node node;
		int state;

		public Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static boolean find(Node node, int data) {
		// write your code here
		if (node == null)
			return false;

		if (node.data == data)
			return true;
		boolean ansLeft = find(node.left, data);
		if (ansLeft == true)
			return true;
		boolean ansRight = find(node.right, data);
		if (ansRight == true)
			return true;
		return false;
	}

	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		// write your code here
		if (node == null)
			return new ArrayList<>();

		if (node.data == data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(data);
			return list;
		}

		ArrayList<Integer> lList = nodeToRootPath(node.left, data);
		if (lList.size() > 0) {
			lList.add(node.data);
			return lList;
		}
		ArrayList<Integer> rList = nodeToRootPath(node.right, data);

		if (rList.size() > 0) {
			rList.add(node.data);
			return rList;
		}

		return new ArrayList<>();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
				null };
		Stack<Pair> st = new Stack<>();

		Node root = new Node(arr[0], null, null);
		Pair rp = new Pair(root, 1);
		int idx = 0;
		st.push(rp);

		while (st.size() > 0) {
			Pair top = st.peek();

			if (top.state == 1) {
				idx++;

				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					st.push(new Pair(top.node.left, 1));
				} else {
					top.node.left = null;

				}

				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					st.push(new Pair(top.node.right, 1));

				} else {
					top.node.right = null;

				}
				top.state++;
			} else {
				st.pop();
			}
		}
//		printBinaryTree(root);
		System.out.println(find(root, 50));
		System.out.println(nodeToRootPath(root, 70));

	}

}
