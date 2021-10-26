package genericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder {
	static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
		
		public Node(int data)
		{
			this.data=data;
		}
		
		public Node() {}
	}
	
	public static void LevelOrderLineWise(Node root)
	{
		Queue<Node> mq=new ArrayDeque<>();
		Queue<Node> cq=new ArrayDeque<>();
		mq.add(root);
		
		while(mq.size()>0)
		{
			Node node=mq.remove();
			System.out.print(node.data+" ");
			
			for(int i=0;i<node.children.size();i++)
			{
				cq.add(node.children.get(i));
			}
			
			if(mq.size()==0)
			{
				mq=cq;
				cq=new ArrayDeque<>();
				System.out.println();
			}
		}
	}
	public static void LevelOrder(Node root)
	{
		Queue<Node> qu=new ArrayDeque<>();
		
		qu.add(root);
		
		while(qu.size()>0)
		{
			Node node=qu.remove();
			System.out.println(node.data);
				
			for(int i=0;i<node.children.size();i++)
				qu.add(node.children.get(i));
		}
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
					st.peek().children.add(node);
				else
					root=node;
				st.push(node);
			}
		}
//		LevelOrder(root);
		LevelOrderLineWise(root);
	}

}
