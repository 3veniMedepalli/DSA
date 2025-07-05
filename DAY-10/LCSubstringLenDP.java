import java.util.*;
class LCSubstringLenDP
{
	static int findLcs(String s1,String s2)
	{
		int ans=0;
		int n=s1.length();
		int m=s2.length();
		int dp[][]=new int[n+1][m+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1]+1;
					ans=Math.max(ans,dp[i][j]);
				}
			}
		}
		return ans;
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String 1:");
		String s1=sc.next();
		System.out.println("Enter String 2:");
		String s2=sc.next();	
		int ans=findLcs(s1,s2);
		System.out.println("The length of the longest common substring is "+ans);
	}
}