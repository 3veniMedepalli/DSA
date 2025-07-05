import java.util.*;
class MinFallPathTriangle
{
	static int findMinFallPath(int n,int a[][])
	{
		int dp[][]=new int[n][n];
		for(int i=0;i<n;i++)
            		dp[n-1][i]=a[n-1][i];
        	for(int i=n-2;i>=0;i--)
		{
            		for(int j=0;j<=i;j++)
			{
                		dp[i][j]=a[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
            		}
		}
        	
        	return dp[0][0];
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