package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeConstruction {
		static class Node{
		public int data;
		public ArrayList<Node> children=new ArrayList<>();
		public Node(int data)
		{
			this.data=data;
		}
		public Node() {}
		
	}
		
		public static void displayTree(Node root)
		{
			if(root==null)
				return;
			
			System.out.print(root.data+" -> ");
			
			for(int i=0;i<root.children.size();i++)
				System.out.print(root.children.get(i).data+",");
			
			System.out.println(".");
			
			for(int i=0;i<root.children.size();i++)
				displayTree(root.children.get(i));
		}
		
		public static int sizeOfTree(Node root)
		{
//			if(root==null)
//				return 0;
			
			int count=0;
			for(int i=0;i<root.children.size();i++)
			{
				count+=sizeOfTree(root.children.get(i));
			}
			return count+1;
			
		}

	public static void main(String[] args) {
		int arr[]= {10 ,20 ,-1 ,30, 50 ,-1 ,60, -1, -1, 40, -1, -1};
		Stack<Node> st=new Stack<>();
		Node root=null;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==-1)
				st.pop();
			else
			{
				Node node =new Node(arr[i]);
				
				if(st.size()>0)
				{
					st.peek().children.add(node);
					
				}
				else
				{
					root=node;
				}
				st.push(node);
				
			}
		}
		
		displayTree(root);
		System.out.println(sizeOfTree(root));
		
	}

}
