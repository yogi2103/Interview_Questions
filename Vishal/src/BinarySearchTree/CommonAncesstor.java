package BinarySearchTree;
import java.io.*;
import java.util.*;
public class CommonAncesstor {
	 public static class Node {
		    int data;
		    Node left;
		    Node right;

		    Node(int data, Node left, Node right) {
		      this.data = data;
		      this.left = left;
		      this.right = right;
		    }
		  }

		  public static class Pair {
		    Node node;
		    int state;

		    Pair(Node node, int state) {
		      this.node = node;
		      this.state = state;
		    }
		  }

		  public static Node construct(Integer[] arr) {
		    Node root = new Node(arr[0], null, null);
		    Pair rtp = new Pair(root, 1);

		    Stack<Pair> st = new Stack<>();
		    st.push(rtp);

		    int idx = 0;
		    while (st.size() > 0) {
		      Pair top = st.peek();
		      if (top.state == 1) {
		        idx++;
		        if (arr[idx] != null) {
		          top.node.left = new Node(arr[idx], null, null);
		          Pair lp = new Pair(top.node.left, 1);
		          st.push(lp);
		        } else {
		          top.node.left = null;
		        }

		        top.state++;
		      } else if (top.state == 2) {
		        idx++;
		        if (arr[idx] != null) {
		          top.node.right = new Node(arr[idx], null, null);
		          Pair rp = new Pair(top.node.right, 1);
		          st.push(rp);
		        } else {
		          top.node.right = null;
		        }

		        top.state++;
		      } else {
		        st.pop();
		      }
		    }

		    return root;
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
		  
		  public static ArrayList<Integer> getNodeToRoot(Node node,int data)
		  {
			  if(node==null)
			  {
				  return new ArrayList<>();
			  }
			  
			  if(node.data==data)
			  {
				  ArrayList<Integer> list=new ArrayList<>();
				  list.add(node.data);
				  return list;
			  } 
			  
			  if(node.data>data)
			  {
				  ArrayList<Integer> lList=getNodeToRoot(node.left,data);
				  if(lList.size()>0)
				  {
					  lList.add(node.data);
					  return lList;
				  }
			  }
			  
			  if(node.data<data)
			  {
				  ArrayList<Integer> rList=getNodeToRoot(node.right,data);
				  if(rList.size()>0)
				  {
					  rList.add(node.data);
					  return rList;
				  }
			  }
			  
			  return new ArrayList<>();
					  
		  }

		  public static int lca(Node node, int d1, int d2) {
		    // write your code here
			  ArrayList<Integer> d1List=getNodeToRoot(node,d1);
			  ArrayList<Integer> d2List=getNodeToRoot(node,d2);
			  
			  int i=d1List.size()-1;
			  int j=d2List.size()-1;
			  
			  while(i>=0 && j>=0 && d1List.get(i)==d2List.get(j))
			  {
				  i--;
				  j--;
			  }
			  
			  i++;
			  
			  return d1List.get(i);
			  
		  }

		  public static void main(String[] args) throws Exception {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine());
		    Integer[] arr = new Integer[n];
		    String[] values = br.readLine().split(" ");
		    for (int i = 0; i < n; i++) {
		      if (values[i].equals("n") == false) {
		        arr[i] = Integer.parseInt(values[i]);
		      } else {
		        arr[i] = null;
		      }
		    }

		    int d1 = Integer.parseInt(br.readLine());
		    int d2 = Integer.parseInt(br.readLine());

		    Node root = construct(arr);
		    int lca = lca(root, d1, d2);
		    System.out.println(lca);
		  }


}
