package genericTree;

import java.util.ArrayList;
import java.util.Stack;

import genericTree.PredecessorAndSuccessor.Node;

class CeilAndFloor {
	
	static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
		
		public Node(int data)
		{
			this.data=data;
		}
		public Node() {}
		
	}
	
	static int floor=Integer.MIN_VALUE;
	static int ceil=Integer.MAX_VALUE;
	public static void ceilAndFloor(Node root,int data)
	{
		
		if(root.data<ceil && data<root.data) {
			ceil=root.data;
		}
		else if(root.data>floor && data>root.data)
		{
			floor=root.data;
		}
		
		for(Node child:root.children)
			ceilAndFloor(child,data);
		
	}

	public static void main(String[] args) {
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80 ,110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Stack<Node> st=new Stack<>();
		Node root=null;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==-1)
				st.pop();
			else
			{
				Node node=new Node(arr[i]);
				
				if(st.size()>0)
					st.peek().children.add(node);
				else
					root=node;
				
				st.push(node);
			}
		}
		
		ceilAndFloor(root,20);
		System.out.println(ceil+" "+floor);
	}

}
