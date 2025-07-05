import java.util.*;
class FrogJumpMinCost
{
	static int findCost(int n,int[] height)
	{
		int dp[]=new int[n];
		dp[1]=Math.abs(height[0]-height[1]);
		for(int i=2;i<n;i++)
		{
			int x=dp[i-1]+Math.abs(height[i]-height[i-1]);
			int y=dp[i-2]+Math.abs(height[i]-height[i-2]);
			dp[i]=Math.min(x,y);
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
		int ans=findCost(n,height);
		System.out.println("The minimum cost is "+ans);
	}
}