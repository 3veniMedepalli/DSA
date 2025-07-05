import java.util.*;
class CountSquaresDP
{
	static int countSquares(int n)
	{
		int[] dp=new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		int i=1;
		dp[0]=0;
		while(i*i<=n)
		{
			int sq=i*i;
			for(int j=sq;j<=n;j++)
			{
				dp[j]=Math.min(dp[j],1+dp[j-sq]);
			}
			i++;
		}
		return dp[n];
		
	}
								
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		int ans=countSquares(n);
		System.out.println("The minimun count is "+ans);
	}
}