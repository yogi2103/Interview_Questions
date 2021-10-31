package genericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import genericTree.CeilAndFloor.Node;

public class KthLargestValue {

	static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}

		public Node() {
		}

	}
	
	static ArrayList<Integer> ansMax=new ArrayList<>();
	public static void getMaximum(Node node)
	{
		ansMax.add(node.data);
		for(Node child:node.children)
			getMaximum(child);
		
		
	}

	public static int kthLargest(Node node, int k) {
		// write your code here
		getMaximum(node);
		Collections.sort(ansMax,Collections.reverseOrder());
		System.out.println(ansMax);
		return ansMax.get(k-1);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };
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
		
		System.out.println(kthLargest(root,8));
	}

}
