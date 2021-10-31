package genericTree;

import java.util.Stack;

import genericTree.TreeTraversal.Node;

public class DiameterOfTree {
	
	public static int height(Node node)
	{
		int height=-1;
		
		for(int i=0;i<node.child.size();i++)
		{
			int ans=height(node.child.get(i));
			if(ans>height)
				height=ans;
		}
		
		return height+1;
	}
	
	public static int diameterofTree(Node node)
	{
		int max1=-1;
		int max2=-1;
		
		for(int i=0;i<node.child.size();i++)
		{
			int ans=height(node.child.get(i));
			if(ans>max1)
			{
				max2=max1;
				max1=ans;
			}
			else if(ans>max2)
				max2=ans;
		}
		
		return max1+max2+2;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1 };
		Stack<Node> st = new Stack<>();

		Node root = null;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node node = new Node(arr[i]);

				if (st.size() > 0)
					st.peek().child.add(node);
				else
					root = node;
				st.push(node);
			}
		}
		System.out.println(height(root));
System.out.println(diameterofTree(root));
	}

}
