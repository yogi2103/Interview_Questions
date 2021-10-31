package BinaryTrees;

import java.util.Stack;

import BinaryTrees.KLevelsDown.Node;
import BinaryTrees.KLevelsDown.Pair;

public class DiameterOfTree {
	
	
	static public int  height(Node node)
	{
		if(node==null)
			return -1;
		
		int lheight=height(node.left);
		int rheight=height(node.right);
		return 1+ Math.max(lheight, rheight);
	}
	
	static int dia=0;
	public static int diameter(Node node)
	{
		
		
		int lheight=height(node.left);
		int rheight=height(node.right);
		
		return lheight+rheight+2;
		
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
		
		System.out.println(diameter(root));
	}

}
