package BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class DiagonalOfBinaryTree {

	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {

		if (root == null)
			return new ArrayList<>();
		Queue<TreeNode> qu = new ArrayDeque<>();
		qu.add(root);

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		while (qu.size() > 0) {
			
			ArrayList<Integer> temp = new ArrayList<>();
			int size = qu.size();

			while (size-- > 0) {
				TreeNode node = qu.remove();
				while (node != null) {
					temp.add(node.val);
					if (node.left != null)
						qu.add(node.left);
					node = node.right;
				}
			}
			ans.add(temp);

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

		ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
		int idx = 0;
		for (ArrayList<Integer> i : ans) {
			System.out.print(idx++ + " -> ");
			for (Integer j : i)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solve();
	}

}
