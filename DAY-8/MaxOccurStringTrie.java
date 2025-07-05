import java.util.*;
class TrieNode
{
	TrieNode child[];
	Boolean isLeaf;
	int c,w;
	public TrieNode()
	{
		child=new TrieNode[26];
		isLeaf=false;
		c=0;
		w=0;
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
		curr.w++;
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
		return curr.w;
	}
	String mostFrequent(String s[])
	{
		int max=-1;
		StringBuilder sb=new StringBuilder();
		while(true)
		{
	
			
			
			
	}
	
}
public class MaxOccurStringTrie
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Trie tr=new Trie();
		System.out.println("Enter no of strings:");
		int n=sc.nextInt();
		System.out.println("Enter strings:");
		String s[]=new String[n];
		for(int i=0;i<n;i++)
		{	
			s[i]=sc.next();
			tr.insert(s[i]);
		}
		String ans=tr.mostFrequent(s);
		System.out.println("The string "+ans+" is most occurred");
	}
}	 
	
		