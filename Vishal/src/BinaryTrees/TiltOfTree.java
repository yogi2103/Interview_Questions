package BinaryTrees;

import java.util.Stack;

import BinaryTrees.KLevelsDown.Node;
import BinaryTrees.KLevelsDown.Pair;

public class TiltOfTree {

	static int tilt = 0;

	public static int tilt(Node node) {
		// write your code here to set the tilt data member
		if (node == null)
			return 0;
		int ltilt = tilt(node.left);
		int rtilt = tilt(node.right);
		tilt += Math.abs(ltilt - rtilt);
		return node.data + ltilt + rtilt;
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
		System.out.println(tilt(root));
	}

}
