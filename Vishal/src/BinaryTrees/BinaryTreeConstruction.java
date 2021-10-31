package BinaryTrees;

import java.util.Stack;

public class BinaryTreeConstruction {
	
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data,Node left,Node right)
		{
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	static class Pair{
		int state;
		Node node;
		public Pair(Node node,int state)
		{
			this.node=node;
			this.state=state;
		}
	}
	
	public static void printBinaryTree(Node root)
	{
		if(root==null)
			return;
		
		if(root.left!=null)
			System.out.print(root.left.data+"-");
		else
			System.out.print("* -");

		System.out.print(" "+root.data+" ");
		
		if(root.right!=null)
			System.out.println(" - "+root.right.data);
		else
			System.out.println("- *");
		
		printBinaryTree(root.left);
		printBinaryTree(root.right);
		

	}
	
	 public static void display(Node node) {
		    if (node == null) {
		      return;
		    }

		    String str = "";
		    str += node.left == null ? "." : node.left.data + "";
		    str += " <- " + node.data + " -> ";
		    str += node.right == null ? "." : node.right.data + "";
		    System.out.println(str);

		    display(node.left);
		    display(node.right);
		  }

		  public static int size(Node node) {
		    // write your code here
			  
			
			  if(node==null)
				  return 0;
			  
			  int size=1;
			  size+=size(node.left);
			  size+=size(node.right);
			  return size;	  
		  }

		  public static int sum(Node node) {
		    // write your code here
			  if(node==null)
				  return 0;
			  
			  int sum=node.data;
			  sum+=sum(node.left);
			  sum+=sum(node.right);
			  
			  return sum;
			  
		  }

		  public static int max(Node node) {
		    // write your code here
			  
			  if(node==null)
				  return  Integer.MIN_VALUE;
			  int lval=node.data;
			  int rval=max(node.left);
			  int rdata=max(node.right);
			  
			  return Math.max(rdata, Math.max(lval, rval));
		  }

		  public static int height(Node node) {
		    // write your code here
			  if(node==null)
				  return -1;
			  
			  int lHeight=height(node.left);
			  int rHeight=height(node.right);
			  
			  return 1+Math.max(lHeight, rHeight);
		  }

	public static void main(String[] args) {
		Integer arr[]= {50 ,25 ,12, null, null, 37 ,30, null, null, null, 75, 62, null ,70, null ,null, 87, null ,null};
		Node root=new Node(arr[0],null,null);
		Pair rp=new Pair(root,1);
		Stack<Pair> st=new Stack<>();
		st.push(rp);
		int idx=0;
		while(st.size()>0)
		{
			Pair top=st.peek();
			if(top.state==1)
			{
				idx++;
				if(arr[idx]!=null)
				{
					top.node.left=new Node(arr[idx],null,null);
					st.push(new Pair(top.node.left,1));
					
				}
				else
				{
					top.node.left=null;
				}
				
				top.state++;
			}
			else if(top.state==2)
			{
				idx++;
				if(arr[idx]!=null)
				{
					top.node.right=new Node(arr[idx],null,null);
					st.push(new Pair(top.node.right,1));
				}
				else
				{
					top.node.right=null;
				}
				top.state++;
			}
			else
			{
				st.pop();
			}
		}
		
		printBinaryTree(root);
//		System.out.println(size(root));
//		System.out.println(sum(root));
//		System.out.println(max(root));
//		System.out.println(height(root));
		
	}

}
