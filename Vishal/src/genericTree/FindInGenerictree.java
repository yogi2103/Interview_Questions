package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class FindInGenerictree {
	
	
	static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
		
		public Node(int data)
		{
			this.data=data;
		}
		
		public Node() {}
		
		
	}
	
	public static boolean find(Node root,int data)
	{
		if(root.data==data)
			return true;
		
		for(int i=0;i<root.children.size();i++)
			{
				boolean ans=find(root.children.get(i),data);
				if(ans==true)
					return true;
			}
		
		return false;
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
		System.out.println(find(root,1120));
		
	}

}
