import java.util.*;
class BinomialQuotientNcr
{
	static int findNcr(int n,int k)
	{
		int dp[][]=new int[n+1][k+1];
		for(int i=0;i<=n;i++)
		{	
			int t=Math.min(i,k);
			for(int j=0;j<=t;j++)
			{
				if(j==0||i==j)
					dp[i][j]=1;
				else
					dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
			}
		}
		return dp[n][k];
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter k:");
		int k=sc.nextInt();
		int ans=findNcr(n,k);
		System.out.println("The Binomial quotient is "+ans);
	}
}

		