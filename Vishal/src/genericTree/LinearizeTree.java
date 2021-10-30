package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class LinearizeTree {

	static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;

		}
		public Node() {}

	}

	public static void linerizetree(Node root) {
		for(Node child:root.children)
			linerizetree(child);
		
		while(root.children.size()>1)
		{
			Node lc=root.children.remove(root.children.size()-1);
			Node slc=root.children.get(root.children.size()-1);
			Node slt=getTail(slc);
			slt.children.add(lc);
		}
		
	}
	
	public static Node getTail(Node root)
	{
		
		while(root.children.size()==1)
		{
			root=root.children.get(0);
		}
		
		return root;
	}
	
	public static void displaytree(Node root)
	{
		System.out.println(root.data+" ");
		
		for(int i=0;i<root.children.size();i++)
			displaytree(root.children.get(i));
	}

	public static void main(String[] args) {
		
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80 ,110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		
		Node root=null;
		
		Stack<Node> st=new Stack<>();
		
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
		
		linerizetree(root);
		displaytree(root);
		
	}

}
