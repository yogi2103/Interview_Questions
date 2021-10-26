package genericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.prefs.NodeChangeEvent;

public class MIrrorOfTree {
	
	static class Node{
		int data;
		ArrayList<Node> children=new ArrayList<>();
		
		public Node(int data)
		{
			this.data=data;
		}
		public Node() {}
	}
	
	
	public static void printMirror(Node root)
	{
		
		Queue<Node> mq=new ArrayDeque<>();
		Queue<Node> cq=new ArrayDeque<>();
		
		mq.add(root);
		
		while(mq.size()>0)
		{
			Node node=mq.remove();
			System.out.print(node.data+" ->");
			
			for(int i=node.children.size()-1;i>=0;i--)
			{
				System.out.print(node.children.get(i).data+",");
				cq.add(node.children.get(i));
			}
			System.out.println(".");
			
			if(mq.size()==0)
			{
				mq=cq;
				cq=new ArrayDeque<>();
				
			}
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80 ,110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};;
		
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
		
		printMirror(root);
	}

}
