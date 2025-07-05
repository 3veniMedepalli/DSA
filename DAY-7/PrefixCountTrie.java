import java.util.*;
class TrieNode
{
	TrieNode child[];
	Boolean isLeaf;
	int c;
	public TrieNode()
	{
		child=new TrieNode[26];
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
			int idx=ch-'a';
			if(curr.child[idx]==null)
				curr.child[idx]=new TrieNode();
			curr=curr.child[idx];
			curr.c++;
		}
		curr.isLeaf=true;
	}
	public int count(String key)
	{
		TrieNode curr=root;
		for(char ch:key.toCharArray())
		{
			if(curr.child[ch-'a']==null)
				return 0;
			curr=curr.child[ch-'a'];
		}
		return curr.c;
	}	
}
public class PrefixCountTrie
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
		int ans=tr.count(s);
		System.out.println(s+" is appeared as a prefix "+ans+" times");
	}
}	 
	
		