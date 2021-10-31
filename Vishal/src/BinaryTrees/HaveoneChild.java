package BinaryTrees;

import java.util.Stack;

import BinaryTrees.KLevelsDown.Node;
import BinaryTrees.KLevelsDown.Pair;

public class HaveoneChild {

	public static void printSingleChildNodes(Node node, Node parent) {
		// write your code here
		if(node==null)
			return;
		
		
		printSingleChildNodes(node.left,node);
		printSingleChildNodes(node.right,node);
		
		if(parent!=null && (parent.left!=null && parent.right==null ||parent.left==null && parent.right!=null ))
		{
			System.out.println(node.data);
		}
		
	}

	public static void main(String[] args) {
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
		printSingleChildNodes(root,null);
	}

}
