import java.util.*;
class CombinationSum
{

	static int combine(int n,int a[],int t)
	{
		int dp[]=new int[t+1];
		dp[0]=1;
		for(int i=1;i<=t;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(a[j-1]<=i)
				{
					dp[i]=dp[i]+dp[i-j];
				}
			}
		}
		return dp[t];		
	}	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter elements:");
		int f[]=new int[n];
		for(int i=0;i<n;i++)
			f[i]=sc.nextInt();
		System.out.println("Enter target:");
		int t=sc.nextInt();
		int ans=combine(n,f,t);
		System.out.println("The maximum combinations are "+ans);
	}
}
