package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PathSum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}
	
	  public static void helper(BinaryTreeNode<Integer> root, ArrayList<Integer> ans,int k)
	    { 
	        if(root==null)
	            return;
	        
	        ans.add(root.data);
	        k=k-root.data;
	        if(root.left==null && root.right==null && k==0)
	            {
	            for(Integer i:ans)
	                System.out.print(i+" ");
	            System.out.println();
	        }
	      
	        helper(root.left,ans,k);
	        helper(root.right,ans,k);
	        ans.remove(ans.size()-1); 
	    }

		public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
			//Your code goes here
	        ArrayList<Integer> ans=new ArrayList<>();
	        helper(root,ans,k);
	       
		}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int k = Integer.parseInt(br.readLine().trim());

		rootToLeafPathsSumToK(root, k);
	}
}
