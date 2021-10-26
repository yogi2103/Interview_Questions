package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeTraversal {
	
	static class Node{
		int data;
		ArrayList<Node> child=new ArrayList<>();
		
		public Node(int data)
		{
			this.data=data;
			
		}
		
		public Node() {}
	}
	
	public static void treeTraversal(Node root)
	{
		System.out.println("Node Pre "+root.data);
		for(int i=0;i<root.child.size();i++)
		{
			System.out.println("Edge Pre "+root.data+"--"+root.child.get(i).data);
			treeTraversal(root.child.get(i));
			System.out.println("Edge post "+root.data+"--"+root.child.get(i).data);
		}
		System.out.println("Node Post "+root.data);
	}

	public static void main(String[] args) {
		
		int arr[]= {10 ,20 ,-1 ,30, 50 ,-1 ,60, -1, -1, 40, -1, -1};
		Stack<Node> st=new Stack<>();
		
		Node root=null;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==-1)
			{
				st.pop();
			}
			else
			{
				Node node=new Node(arr[i]);
				
				if(st.size()>0)
					st.peek().child.add(node);
				else
					root=node;
				st.push(node);
			}
		}
		
		treeTraversal(root);
	}

}
