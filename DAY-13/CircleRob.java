import java.util.*;
class CircleRob
{
	static int findCost(int n,int[] num)
	{
		int dp[]=new int[n];
		dp[0]=num[0];
		dp[1]=Math.max(num[0],num[1]);
		for(int i=2;i<n;i++)
		{
			int x=dp[i-1];
			int y=dp[i-2]+num[i];
			dp[i]=Math.max(x,y);
		}
		return dp[n-1];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter numbers:");
		int num[]=new int[n];
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		int a1[]=new int[n-1];
		int a2[]=new int[n-1];
		for(int i=0;i<n-1;i++)
			a1[i]=num[i+1];
		for(int i=0;i<n-1;i++)
			a2[i]=num[i];
		int ans1=findCost(n-1,a1);
		int ans2=findCost(n-1,a2);
		int ans=Math.max(ans1,ans2);
		System.out.println("The maximum is "+ans);
	}
}