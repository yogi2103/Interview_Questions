package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

import BinaryTrees.KLevelsDown.Node;
import BinaryTrees.KLevelsDown.Pair;

public class KNodesAway {
	
	
	public static void KLevelDown(Node root,int k,Node blocker)
	{
		if(root==null || k<0|| root==blocker)
			return;
		
		if(k==0)
			System.out.println(root.data);
		
		KLevelDown(root.left,k-1,blocker);
		KLevelDown(root.right,k-1,blocker);
		
	}
	
	public static ArrayList<Node> nodeToRoot(Node root,int data){
		
		if(root==null)
			return new ArrayList<>();
		
		if(root.data==data)
		{
			ArrayList<Node> al=new ArrayList<>();
			al.add(root);
			return al;
		}
		
		ArrayList<Node> lAL=nodeToRoot(root.left,data);
		if(lAL.size()>0)
		{
			lAL.add(root);
			return lAL;
		}
		
		ArrayList<Node> rAL=nodeToRoot(root.right,data);
		if(rAL.size()>0)
		{
			rAL.add(root);
			return rAL;
		}
		
		return new ArrayList<>();
		
	}

	 public static void printKNodesFar(Node node, int data, int k) {
	    // write your code here
//		 System.out.println(nodeToRoot(node,data));
		 
		ArrayList<Node> nodeList =nodeToRoot(node,data);
		for(int i=0;i<nodeList.size();i++)
			KLevelDown(nodeList.get(i), k-i,i==0?null:nodeList.get(i-1));
		 
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
		printKNodesFar(root,62,1);
	}

}
