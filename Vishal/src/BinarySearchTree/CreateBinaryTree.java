package BinarySearchTree;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class CreateBinaryTree {
	
	static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	
	public static BinaryTreeNode<Integer> createBST(int[] arr, int si,int  ei){
        
            if(si>ei || ei<0)
                return null;
            
            
            int mid=si+(ei-si)/2;
            
             BinaryTreeNode<Integer> root=new BinaryTreeNode<>(arr[mid]);
            root.left=createBST(arr,si,mid-1);
            root.right=createBST(arr,mid+1,ei);
            
            return root;
            
        }
   	
	
		public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){ 
            return createBST(arr,0,n-1);
		}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	private static void preOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int len = Integer.parseInt(st.nextToken());
		int arr[] = new int[len];
		if(len>0)
		{
			st = new StringTokenizer(br.readLine());
		}
		for(int i=0;i<len;i++)
		{
		    arr[i]=Integer.parseInt(st.nextToken());
		}
		BinaryTreeNode<Integer> ans =SortedArrayToBST(arr, len);
		preOrder(ans);
	}

}
