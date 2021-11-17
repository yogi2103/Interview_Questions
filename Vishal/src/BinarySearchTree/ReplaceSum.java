package BinarySearchTree;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


//class QueueEmptyException extends Exception {
//}

//class QueueUsingLL<T> {
//
//	class Node<T> {
//		T data;
//		Node<T> next;
//
//		Node(T data) {
//			this.data = data;
//		}
//	}
//
//	private Node<T> head;
//	private Node<T> tail;
//	private int size = 0;
//
//	public int size() {
//		return size;
//	}
//
//	public boolean isEmpty() {
//		if (size == 0) {
//			return true;
//		}
//		return false;
//	}
//
//	public T front() throws QueueEmptyException {
//		if (size == 0) {
//			QueueEmptyException e = new QueueEmptyException();
//			throw e;
//		}
//
//		return head.data;
//	}
//
//	public void enqueue(T element) {
//		Node<T> newNode = new Node<T>(element);
//
//		if (head == null) {
//			head = newNode;
//			tail = newNode;
//		} else {
//			tail.next = newNode;
//			tail = newNode;
//		}
//
//		size++;
//	}
//
//	public T dequeue() throws QueueEmptyException {
//		if (head == null) {
//			QueueEmptyException e = new QueueEmptyException();
//			throw e;
//		}
//		if (head == tail) {
//			tail = null;
//		}
//		T temp = head.data;
//		head = head.next;
//		size--;
//		return temp;
//	}
//}

//class BinaryTreeNode<T> {
//	T data;
//	BinaryTreeNode<T> left;
//	BinaryTreeNode<T> right;
//
//	public BinaryTreeNode(T data) {
//		this.data = data;
//	}
//}

public class ReplaceSum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	public static void printLevelWiseAtDiffLevel(BinaryTreeNode<Integer> root) throws QueueEmptyException {
		if (root == null)
			return;
		QueueUsingLL<BinaryTreeNode<Integer>> q = new QueueUsingLL<BinaryTreeNode<Integer>>();
		q.enqueue(root);
		q.enqueue(null);
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> first = q.front();
			q.dequeue();
			if (first == null) {
				if (q.isEmpty()) {
					break;
				}
				System.out.println();
				q.enqueue(null);
				continue;
			}
			System.out.print(first.data + " ");
			if (first.left != null) {
				q.enqueue(first.left);
			}
			if (first.right != null) {
				q.enqueue(first.right);
			}
		}
	}
	static int finalSum=0;
	public static void helper(BinaryTreeNode<Integer> root,int data,int sum)
	{
		if(root==null)
		{
			finalSum=sum;
			return ;
		}
		
		
		if(data<=root.data)
			sum+=root.data;
		
		helper(root.left,data,sum);
		helper(root.right,data,sum);
			
	}
	public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root)
	{
		Queue<BinaryTreeNode<Integer>> qu=new ArrayDeque<>();
		Queue<BinaryTreeNode<Integer>> cu=new ArrayDeque<>();
		qu.add(root);
		
		while(qu.size()>0)
		{
			BinaryTreeNode<Integer> node=qu.remove();
			helper(root,node.data,0);
			System.out.print(finalSum+" ");
			if(node.left!=null)
				cu.add(node.left);
			if(node.right!=null)
				cu.add(node.right);
			
			
			if(qu.size()==0)
			{
				qu=cu;
				cu=new ArrayDeque<>();
				System.out.println();
			}
			
		}
		
	}

	public static void main(String[] args) throws IOException, QueueEmptyException {
		BinaryTreeNode<Integer> root = takeInput();
		replaceWithLargerNodesSum(root);
//		printLevelWiseAtDiffLevel(root);
	}

}