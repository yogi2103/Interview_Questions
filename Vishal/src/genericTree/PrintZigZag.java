package genericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class PrintZigZag {

	static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;

		}

		public Node() {
		}
	}

	public static void printZigZag(Node root) {
		
		Stack<Node> mq=new  Stack<>();
		Stack<Node> cq=new Stack<>();
		
		mq.add(root);
		int level=0;
		
		
		while(mq.size()>0)
		{
			Node node=mq.pop();
			System.out.print(node.data+" ");
			
			if(level%2==0)
			{
				for(int i=0;i<node.children.size();i++)
					cq.push(node.children.get(i));
				
			}
			else
			{
				for(int i=node.children.size()-1;i>=0;i--)
					cq.push(node.children.get(i));
			}
			
			if(mq.size()==0)
			{
				mq=cq;
				cq=new Stack<>();
				System.out.println();
				level++;
			}
		}
		
		

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
		printZigZag(root);
	}

}
