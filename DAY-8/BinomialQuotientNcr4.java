import java.util.*;
class BinomialQuotientNcr4
{
	static int[] findNcr(int n)
	{
		ArrayList<Integer>ans=new ArrayList<>();
		int dp[][]=new int[n+1][n+1];
		for(int i=0;i<=n;i++)
		{	
			int t=Math.min(i,n);
			for(int j=0;j<=t;j++)
			{
				if(j==0||i==j)
					dp[i][j]=1;
				else
					dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
			}
		}
		return dp[n];
	
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		int[] ans=findNcr(n);
		int res=0;
		for(int x:ans)
			res=res+x;
		System.out.println(res);
		
	}
}

		