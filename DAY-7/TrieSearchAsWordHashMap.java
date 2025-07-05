import java.util.*;
class TrieNode
{
	HashMap<Character,TrieNode>child;
	Boolean isLeaf;
	int c,w;
	public TrieNode()
	{
		child=new HashMap<>();
		isLeaf=false;
		c=0;
	}
}
class Trie
{
	TrieNode root;
	Trie()
	{
		root=new TrieNode();
	}
	public void insert(String key)
	{
		TrieNode curr=root;
		for(char ch:key.toCharArray())
		{
			if(curr.child.get(ch)==null)
				curr.child.put(ch,new TrieNode());
			curr=curr.child.get(ch);
			curr.c++;
		}
		curr.isLeaf=true;
		curr.w++;
	}
	public boolean search(String key)
	{
		TrieNode curr=root;
		for(char ch:key.toCharArray())
		{
			if(!curr.child.containsKey(ch))
				return false;
			curr=curr.child.get(ch);
		}
		return curr.isLeaf;
	}	
}
public class TrieSearchAsWordHashMap
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Trie tr=new Trie();
		System.out.println("Enter no of strings:");
		int n=sc.nextInt();
		System.out.println("Enter strings:");
		for(int i=0;i<n;i++)
		{	
			String s=sc.next();
			tr.insert(s);
		}
		System.out.println("Enter string to be searched");
		String s=sc.next();
		if(tr.search(s))
			System.out.println(s+" is a word in trie");
		else
			System.out.println(s+" is not a word in trie");
	}
}	 
	
		