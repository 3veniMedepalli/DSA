import java.util.*;
class CountNoOfSubSeq
{
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
					dp[i][j]=(dp[i][j-1]+dp[i-1][j])+1;
				}
				else
					dp[i][j]=(dp[i][j-1]+dp[i-1][j])-dp[i-1][j-1];
			}
		}
		return dp[n][m];
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String 1:");
		String s1=sc.next();
		System.out.println("Enter String 2:");
		String s2=sc.next();	
		int ans=findLcs(s1,s2);
		System.out.println("The no of common subsequence is "+ans);
	}
}