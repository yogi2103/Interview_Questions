package BinaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import BinaryTrees.FindAndNodeToRootPath.Node;
import BinaryTrees.FindAndNodeToRootPath.Pair;

public class KLevelsDown {

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

	public static void printKLevelsDown(Node node, int k) {
		// write your code here
		Queue<Node> mqu=new ArrayDeque<>();
		Queue<Node> cqu=new ArrayDeque<>();
		mqu.add(node);
		int level=0;
		
		while(mqu.size()>0)
		{
			Node front=mqu.remove();
			
			if(front.left!=null)
				cqu.add(front.left);
			if(front.right!=null)
				cqu.add(front.right);
			
			if(level==k)
			{
				System.out.println(front.data);
			}
			if(mqu.size()==0)
			{
				mqu=cqu;
				cqu=new ArrayDeque<>();
				level++;
			}
			
				
			
		}
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
		
		printKLevelsDown(root,3);
	}

}
