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
	public boolean search(String key)
	{
		TrieNode curr=root;
		for(char ch:key.toCharArray())
		{
			if(curr.child[ch-'a']==null)
				return false;
			curr=curr.child[ch-'a'];
		}
		return curr.isLeaf;
	}	
}
public class WordBreakTrieDp
{
	boolean wordBreak(String s[],String str)
	{
		Trie tr=new Trie();
		int n=str.length();
		for(int i=0;i<s.length;i++)
			tr.insert(s[i]);
		boolean dp[]=new boolean[n+1];
		dp[0]=true;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<=i-1;j++)
			{
				String temp=str.substring(j,i);
				if(dp[j]&&tr.search(temp))
				{
					dp[i]=true;
					break;
				}
			}
		}
		return dp[n];
	}
		
		 
	public static void main(String args[])
	{
		 WordBreakTrieDp w=new  WordBreakTrieDp();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of strings:");
		int n=sc.nextInt();
		System.out.println("Enter strings:");
		String s[]=new String[n];
		for(int i=0;i<n;i++)
		{	
			s[i]=sc.next();
		}
		System.out.println("Enter string to be searched");
		String str=sc.next();
		System.out.println(w.wordBreak(s,str));
	}
}	 
	
		