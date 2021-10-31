package BinaryTrees;

import java.util.Stack;

import BinaryTrees.FindAndNodeToRootPath.Node;
import BinaryTrees.FindAndNodeToRootPath.Pair;

public class LeftClonedTree {
	
	public static void display(Node node) {
	    if (node == null) {
	      return;
	    }

	    String str = "";
	    str += node.left == null ? "." : node.left.data + "";
	    str += " <- " + node.data + " -> ";
	    str += node.right == null ? "." : node.right.data + "";
	    System.out.println(str);

	    display(node.left);
	    display(node.right);
	  }
	  public static Node createLeftCloneTree(Node node){
		    // write your code here
		  if(node==null)
			  return null;
		  
			  Node newNode=new Node(node.data,null,null);
			  Node prevLeft=node.left;
			  node.left=newNode;
			  newNode.left=prevLeft;
			  createLeftCloneTree(prevLeft);
		  
//		  50 <- 50 -> 75
//		  25 <- 50 -> .
//		  25 <- 25 -> 37
//		  12 <- 25 -> .
//		  12 <- 12 -> .
//		  . <- 12 -> .
//		  37 <- 37 -> .
//		  . <- 37 -> .
//		  75 <- 75 -> 87
//		  62 <- 75 -> .
//		  62 <- 62 -> .
//		  . <- 62 -> .
//		  87 <- 87 -> .
//		  . <- 87 -> .
		  
		  
		 
		  createLeftCloneTree(node.right);
		  
		  return node;
		  
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

		createLeftCloneTree(root);
		display(root);

	}

}
