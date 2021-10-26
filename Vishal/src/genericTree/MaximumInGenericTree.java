package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumInGenericTree {

	static class Node{
		int data;
		ArrayList<Node> child=new ArrayList<>();
		public Node(int data)
		{
			this.data=data;
		}
		
		public Node() {}
		
	}
	
	public static int  heightOfTree(Node root)
	{
		
		int height=-1;
		
		for(int i=0;i<root.child.size();i++)
		{
			int h=heightOfTree(root.child.get(i));
			if(h>height)
				height=h;
		}
		
		
		return height+1;
		
	}
	public static int maxInTree(Node root)
	{
		
		
		int maxVal=Integer.MIN_VALUE;;
		for(int i=0;i<root.child.size();i++)
		{
			int max=maxInTree(root.child.get(i));
			if(max>maxVal)
				maxVal=max;
		}
		
		if(maxVal>root.data)
			return maxVal;
		return root.data;
	}
	public static void main(String[] args) {
		
		int arr[]= {10 ,20, -1, 30, 50, -1, 60, -1, -1, 40 ,-1 ,-1};
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
				{
					st.peek().child.add(node);
				}
				else
					root=node;
				
				st.push(node);
			}
		}
		
		System.out.println(maxInTree(root));
		System.out.println(heightOfTree(root));
	}

}
