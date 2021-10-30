package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class SimilarTree {

	
	static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();	
		public Node(int data)
		{
			this.data=data;
		}
		
		public Node() {}
		
	}
	
	 public static boolean isSame(Node node1,Node node2)
	 {
		 if(node1.children.size()!=node2.children.size())
			 return false;
		 
		 for(int i=0;i<node1.children.size();i++)
		 {
			 boolean ans=isSame(node1.children.get(i),node2.children.get(i));
			 if(ans==false)
				 return false;
		 }
		 
		 return true;
		 
	 }
	 
	 public static boolean isSameMirror(Node node1,Node node2)
	 {
		 
		 if(node1.children.size()!=node2.children.size())
			 return false;
		 
		 for(int i=0,j=node2.children.size()-1;i<node1.children.size() && j>=0 ;i++,j--)
		 {
			 if(isSameMirror(node1.children.get(i),node2.children.get(j))==false)
				 return false;
		 }
		 
		 return true;	 
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
		
		

	}

}
