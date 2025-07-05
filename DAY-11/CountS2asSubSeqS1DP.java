import java.util.*;
class CountS2asSubSeqS1DP
{
	static int findCount(String s1,String s2)
	{
		int n=s1.length();
		int m=s2.length();
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<=n;i++)
			dp[0][i]=1;
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s2.charAt(i-1)==s1.charAt(j-1))
					dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
				else
					dp[i][j]=dp[i][j-1];
			}	
		}
		return dp[m][n];
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String 1:");
		String s1=sc.next();
		System.out.println("Enter String 2:");
		String s2=sc.next();
		int ans=findCount(s1,s2);
		System.out.println("The number of times "+s2+" occurs in "+s1+" as subsequence is "+ans);
	}
}