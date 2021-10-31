package genericTree;

import java.util.ArrayList;
import java.util.Stack;

import genericTree.SimilarTree.Node;

public class PredecessorAndSuccessor {
	
	static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
		
		public Node(int data)
		{
			this.data=data;
		}
		public Node() {}
		
	}
	static int state=0;
	static int predecessor=-1;
	static int successor=-1;
	
	public static void predecessorAndSuccessor(Node node,int data)
	{
		if(state==0)
		{
			if(node.data==data)
				state=1;
			else
				predecessor=node.data;
		}
		else if(state==1)
		{
			successor=node.data;
			state=2;
		}
		
		
		for(Node child:node.children)
			predecessorAndSuccessor(child, data);
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
		predecessorAndSuccessor(root,90);
		System.out.println(predecessor+" "+successor);
		
	}

}
