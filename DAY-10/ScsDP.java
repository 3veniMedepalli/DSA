import java.util.*;
class ScsDP
{
	static String findScs(String s1,String s2)
	{
		int[][] dp=findLcs(s1,s2);
		int n=s1.length();
		int m=s2.length();
		int i=n,j=m;
		StringBuilder sb=new StringBuilder();
		while(i>0&&j>0)
		{
			if(s1.charAt(i-1)==s2.charAt(j-1))
			{
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j]>dp[i][j-1])
			{
				sb.append(s1.charAt(i-1));
				i--;
			}
			else
			{
				sb.append(s2.charAt(j-1));
				j--;
			}
		}
		while(i>0)
		{
			sb.append(s1.charAt(i-1));
			i--;
		}
		while(j>0)
		{
			sb.append(s2.charAt(j-1));
			j--;
		}
		sb.reverse();
		return sb.toString();
				
	}
	static int[][] findLcs(String s1,String s2)
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
		return dp;
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String 1:");
		String s1=sc.next();
		System.out.println("Enter String 2:");
		String s2=sc.next();	
		String ans=findScs(s1,s2);
		System.out.println("The shortest common subsequence is "+ans);
	}
}