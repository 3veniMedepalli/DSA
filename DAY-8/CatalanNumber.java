import java.util.*;
class CatalanNumber
{
	static int find(int n)
	{
		int dp[]=new int[n+1];
		dp[0]=1;dp[1]=1;
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{	
				dp[i]+=(dp[j]*(dp[i-j-1]));
			}
		}
		return dp[n];
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.print("The catalan number is :"+find(n));
	}
}
