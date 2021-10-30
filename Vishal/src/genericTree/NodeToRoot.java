package genericTree;

import java.util.ArrayList;
import java.util.Stack;

public class NodeToRoot {

	static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();

		public Node(int data) {
			this.data = data;
		}

		public Node() {
		}

	}
	public static int lowestCommon(Node root,int data1,int data2)
	{
		ArrayList<Integer> aData1=nodeToRoot(root, data1);
		ArrayList<Integer> aData2=nodeToRoot(root, data2);
		int i=aData1.size()-1;
		int j=aData2.size()-1;
		while(i>=0 && j>=0&& aData1.get(i)==aData2.get(j))
		{
			i--;j--;
		}
		j++;
		return aData2.get(j);
	}
	
	public static ArrayList<Integer> nodeToRoot(Node root,int data)
	{
		if(root.data==data)
		{
			ArrayList<Integer> arr=new ArrayList<>();
			arr.add(data);
			return arr;
		}
		
		for(int i=0;i<root.children.size();i++)
		{
			ArrayList<Integer> ans=nodeToRoot(root.children.get(i),data);
			if(ans.size()>0)
			{
				ans.add(root.data);
				return ans;
			}
		}
		
		ArrayList<Integer> ans=new ArrayList<>(); 
		return ans;
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
		
		System.out.println(nodeToRoot(root,120));
		System.out.println(lowestCommon(root,50,110));
	}

}
