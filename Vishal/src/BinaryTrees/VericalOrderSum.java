package BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class VericalOrderSum {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}
	public static class Pair{
		int level;
		TreeNode node;
		public Pair(int level,TreeNode node)
		{
			this.level=level;
			this.node=node;
		}
	}

	public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
			if(root==null)
				return new ArrayList<>();
			Map<Integer,Integer> map=new HashMap<>();
			Queue<Pair> qu=new ArrayDeque<>();
			qu.add(new Pair(0,root));
			int min=0,max=0;
			
			while(qu.size()>0)
			{
				
				int size=qu.size();
				
				
				while(size-->0)
				{
					Pair rmnode=qu.remove(); 
					map.putIfAbsent(rmnode.level, 0);
					min=Math.min(min, rmnode.level);
					max=Math.max(max, rmnode.level);
					map.put(rmnode.level, map.get(rmnode.level)+rmnode.node.val);
					
					if(rmnode.node.left!=null) qu.add(new Pair(rmnode.level-1,rmnode.node.left));
					if(rmnode.node.right!=null) qu.add(new Pair(rmnode.level+1,rmnode.node.right));
					
				}
			}
			ArrayList<Integer> ans=new ArrayList<>();
			for(int i=min;i<=max;i++)
			{
				
				ans.add(map.get(i));
			}
			return ans;
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

		ArrayList<Integer> ans = verticalOrderSum(root);
		for (Integer j : ans)
			System.out.println(j);

	}

	public static void main(String[] args) {
		solve();
	}

}
