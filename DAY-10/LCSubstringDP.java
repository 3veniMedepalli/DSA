import java.util.*;
class LCSubstringDP
{
	static String findLcs(String s1,String s2)
	{
		int ans=-1;
		int start=-1,end=-1;
		int n=s1.length();
		int m=s2.length();
		int dp[][]=new int[n+1][m+1];
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{
					dp[i][j]=dp[i-1][j-1]+1;
					if(dp[i][j]>ans)
					{
						ans=dp[i][j];
						start=i;end=j;
					}
				}
			}
		}
		StringBuilder sb=new StringBuilder();
		while(dp[start][end]!=0)
		{
			sb.append(s1.charAt(start-1));
			start=start-1;
			end=end-1;
		}
		sb.reverse();
		return sb.toString();
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String 1:");
		String s1=sc.next();
		System.out.println("Enter String 2:");
		String s2=sc.next();	
		String ans=findLcs(s1,s2);
		System.out.println("The value of the longest common substring is "+ans);
	}
}