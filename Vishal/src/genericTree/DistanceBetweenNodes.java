package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class DistanceBetweenNodes {

	static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
		public Node(int data)
		{
			this.data=data;
		}
		
	}
	public static ArrayList<Integer> getParents(Node root,int data)
	{
		if(root.data==data)
		{
			ArrayList<Integer> arr=new ArrayList<>();
			arr.add(data);
			return  arr;	
		}
		for(int i=0;i<root.children.size();i++)
		{
			ArrayList<Integer> ans=getParents(root.children.get(i),data);
			if(ans.size()>0)
			{
				ans.add(root.data);
				return ans;
			}
		}
		return new ArrayList<>();
	}
	public static int distanceBetween(Node root,int data1,int data2)
	{
		ArrayList<Integer> data1Parents=getParents(root,data1);
		ArrayList<Integer> data2Parents=getParents(root,data2);
		
		
		int i=0,j=0;
		
		while(i<data1Parents.size() && j<data2Parents.size() && data1Parents.get(i)!=data2Parents.get(j))
		{
			i++;
			j++;
			
		}
		i--;
		j--;
		return i+j+1;
		
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
		
		System.out.println(distanceBetween(root,50,100));
	}

}
