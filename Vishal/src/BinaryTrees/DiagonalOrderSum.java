package BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class DiagonalOrderSum {
	 public static Scanner scn = new Scanner(System.in);

	  public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    TreeNode(int val) {
	      this.val = val;
	    }
	  }

		public static ArrayList<Integer> diagonalOrderSum(TreeNode root){
			if(root==null)
				return new ArrayList<>();
			Queue<TreeNode> qu=new ArrayDeque<>();
			
			qu.add(root);
			ArrayList<Integer> al=new ArrayList<>();
			while(qu.size()>0)
			{
				int size=qu.size();
				int sum=0;
				while(size-->0)
				{
					TreeNode node=qu.remove();
					
					
					while(node!=null)
					{
						if(node.left!=null)
							qu.add(node.left);
						sum+=node.val;
						node=node.right;
					}
				}
				al.add(sum);
			}
			return al;
			

	  }

	  // input_section=================================================

	  public static TreeNode createTree(int[] arr, int[] IDX) {
	    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
	      IDX[0]++;
	      return null;
	    }
	    TreeNode node = new TreeNode(arr[IDX[0]++]);
	    node.left = createTree(arr, IDX);
	    node.right = createTree(arr, IDX);

	    return node;
	  }

	  public static void solve() {
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++)
	      arr[i] = scn.nextInt();

	    int[] IDX = new int[1];
	    TreeNode root = createTree(arr, IDX);

	    ArrayList<Integer> ans = diagonalOrderSum(root);
	    for (Integer j : ans)
	      System.out.print(j + " ");

	  }

	  public static void main(String[] args) {
	    solve();
	  }
}
