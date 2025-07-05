import java.util.*;
class FaridaPrincess
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
		int ans=findCost(n,num);
		System.out.println("The maximum is "+ans);
	}
}