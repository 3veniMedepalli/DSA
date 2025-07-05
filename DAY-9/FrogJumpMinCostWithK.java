import java.util.*;
class FrogJumpMinCostWithK
{
	static int findCost(int n,int[] height,int k)
	{
		int dp[]=new int[n];
		dp[1]=Math.abs(height[0]-height[1]);
		for(int i=2;i<n;i++)
		{
			int t=Integer.MAX_VALUE;
			int min=Math.min(i,k);
			for(int j=1;j<=min;j++)
			{
				int x=dp[i-j]+Math.abs(height[i-j]-height[i]);
				t=Math.min(t,x);
			}
			dp[i]=t;
		}
		return dp[n-1];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter Heights:");
		int height[]=new int[n];
		for(int i=0;i<n;i++)
			height[i]=sc.nextInt();
		System.out.println("Enter K:");
		int k=sc.nextInt();
		int ans=findCost(n,height,k);
		System.out.println("The minimum cost is "+ans);
	}
}