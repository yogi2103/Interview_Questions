package Tries;

public class TriesImpl {
	
	static class TrieNode{
		char data;
		boolean isTerminating;
		TrieNode children[];
		
		public TrieNode(char data)
		{
			this.data=data;
			this.isTerminating=false;
			this.children=new TrieNode[26];
		}
	}
	
	
	static class Tries{
		private TrieNode root;
		
		public Tries()
		{
			this.root=new TrieNode('\0');
		}
		
		public void add(String words)
		{
			addHelper(root,words);
		}
		
		public void addHelper(TrieNode root,String words)
		{
			if(words.length()==0)
			{
				root.isTerminating=true;
				return;
			}
			
			int index=words.charAt(0)-'a';
			TrieNode child=root.children[index];
			
			if(child==null)
			{
				child=new TrieNode(words.charAt(0));
				root.children[index]=child;
			}
			
			addHelper(child, words.substring(1));
		}
		
		public boolean search(String words)
		{
			return searchhelper(root, words);
		}
		
		
		public void delete(String words)
		{
			 deleteHelper(root,words);	
		}
		
		public static void deleteHelper(TrieNode root,String data)
		{
			if(data.length()==0)
			{
				if(root.isTerminating==true)
				{
					root.isTerminating=false;
					return;
				}
			}
				
				int index=data.charAt(0)-'a';
				TrieNode node=root.children[index];
				if(node==null)
					return;
				deleteHelper(node,data.substring(1));
		}
		public boolean searchhelper(TrieNode root,String words)
		{
			if(words.length()==0)
			{
				if( root.isTerminating==true)
					return true;
				else 
					return false;
			}
			
			int index=words.charAt(0)-'a';
			TrieNode child=root.children[index];
			if(child!=null)
			{
				if(searchhelper(child, words.substring(1))==true)
					return true;
			}
			
			return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries tries=new Tries();
		tries.add("vishal");
		tries.add("vish");
		
		System.out.println(tries.search("vishal"));
		tries.delete("vishal");
		System.out.println(tries.search("vishal"));

	}

}
