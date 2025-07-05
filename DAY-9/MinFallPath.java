import java.util.*;
class MinFallPath
{
	static int findMinFallPath(int n,int a[][])
	{
		int dp[][]=new int[n][n];
		dp[0]=a[0];
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				int x=dp[i-1][j];
                		if (j<n-1)                     
					x=Math.min(x,dp[i-1][j+1]);
                		dp[i][j]=a[i][j]+x;
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
			min=Math.min(min,dp[n-1][i]);
		return min;
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		int a[][]=new int[n][n];
		System.out.println("Enter elements:");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j]=sc.nextInt();
		int ans=findMinFallPath(n,a);
		System.out.println("The minimum fall path is "+ans);
	}
}