package genericTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

import genericTree.TreeTraversal.Node;

public class RemoveLeaves {
	public static void removeLeaves(Node node) {
		
		
		for(int i=node.child.size()-1;i>=0;i--)
		{
			Node child=node.child.get(i);
			if(child.child.size()==0)
				node.child.remove(child);
		}
		for(Node child:node.child)
			removeLeaves(child);
		
		
	}
	
	public static void LevelOrder(Node root)
	{
		Queue<Node> qu=new ArrayDeque<>();
		
		qu.add(root);
		
		while(qu.size()>0)
		{
			Node node=qu.remove();
			System.out.println(node.data);
				
			for(int i=0;i<node.child.size();i++)
				qu.add(node.child.get(i));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		removeLeaves(root);
		LevelOrder(root);
		
	}

}
