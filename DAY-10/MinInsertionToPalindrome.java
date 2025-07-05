import java.util.*;
class MinInsertionToPalindrome
{
	static int findMinInsert(String s)
	{
		StringBuilder sb=new StringBuilder(s);
		sb.reverse();
		int lcs=findLcs(s,sb.toString());
		return (s.length())-lcs;
	}
	static int findLcs(String s1,String s2)
	{
		int n=s1.length();
		int m=s2.length();
		int dp[][]=new int[n+1][m+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=(dp[i-1][j-1])+1;
				}
				else
					dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		return dp[n][m];
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String s=sc.next();	
		int ans=findMinInsert(s);
		System.out.println("The Minimum insertions required to make a string palindrome is "+ans);
	}
}