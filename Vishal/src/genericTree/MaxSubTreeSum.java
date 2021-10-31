package genericTree;

import java.util.ArrayList;
import java.util.Stack;

import genericTree.KthLargestValue.Node;

public class MaxSubTreeSum {
	static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}

		public Node() {
		}

	}

	static int nodeData = 0;
	static int nodeSum = Integer.MIN_VALUE;

	public static int maxSumTree(Node node) {
		int sum = 0;
		if (node.children.size() == 0)
			return node.data;

		for (Node child : node.children) {
			sum += maxSumTree(child);

		
		}
		if (sum + node.data > nodeSum) {
			nodeSum = sum + node.data;
			nodeData = node.data;
		}

		return sum+node.data;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1 };
		Stack<Node> st = new Stack<>();
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1)
				st.pop();
			else {
				Node node = new Node(arr[i]);

				if (st.size() > 0)
					st.peek().children.add(node);
				else
					root = node;

				st.push(node);
			}
		}
		maxSumTree(root);
		System.out.println(nodeData+"@"+nodeSum);

	}

}
