import java.util.*;
class CountSquMatrixWith1
{
	static int count(int a[][],int n,int m)
	{
		int[][] dp=new int[n][m];
		int ans=0;
		for(int i=0;i<m;i++)
		{
			dp[0][i]=a[0][i];
			ans=ans+a[0][i];
		}
		for(int i=1;i<n;i++)
		{
			dp[i][0]=a[i][0];
			ans=ans+a[i][0];
		}
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<m;j++)
			{
				if(a[i][j]==1)
				{
					dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
					ans=ans+dp[i][j];
				}
			}
		}
		return ans;
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter m:");
		int m=sc.nextInt();
		int[][]a=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
				a[i][j]=sc.nextInt();
		}	
		int ans=count(a,n,m);
		System.out.println("The no of square matrix with 1's is "+ans);
	}
}