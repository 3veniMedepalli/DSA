import java.util.*;
class BinomialQuotientNcr3
{
	static int[][] findNcr(int n,int k)
	{
		ArrayList<Integer>ans=new ArrayList<>();
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
		return dp;
	
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter k:");
		int k=sc.nextInt();
		int[][] ans=findNcr(n,k);
		for(int a[]:ans)
		{	
			for(int x:a)
				System.out.print(x+" ");
			System.out.println();
		}
	}
}

		