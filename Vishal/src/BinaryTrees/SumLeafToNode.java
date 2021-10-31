package BinaryTrees;

import java.util.Stack;

import BinaryTrees.KLevelsDown.Node;
import BinaryTrees.KLevelsDown.Pair;

public class SumLeafToNode {
	public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
		// write your code here
		
		if(node==null)
			return;
		sum+=node.data;
		path+=node.data+" ";
		if(node.left==null && node.right==null && sum<=hi && sum>=lo)
			System.out.println(path);
		
		
		pathToLeafFromRoot(node.left,path,sum,lo,hi);
		pathToLeafFromRoot(node.right,path,sum,lo,hi);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = { 50, 25 ,12, null, null, 37, 30, null ,null, 40, null ,null, 75, 62, 60, null ,null ,70, null, null ,87, null, null };
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
		pathToLeafFromRoot(root,"",0,150,250);
	}

}
