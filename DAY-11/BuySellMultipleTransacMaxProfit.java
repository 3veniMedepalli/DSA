import java.util.*;
class BuySellMultipleTransacMaxProfit
{
	static int findProfit(int n,int p[])
	{
		int ans=0;
		int lmin=p[0],lmax=p[0];
		int i=0;
		while(i<n-1)
		{
			while(i<n-1&&p[i]>=p[i+1])
				i=i+1;
			if(i==n-1)
				break;
			lmin=p[i];
			i++;
			while(i<n-1&&p[i]<p[i+1])
				i=i+1;
			lmax=p[i];
			ans+=(lmax-lmin);
		}
		return ans;
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		int p[]=new int[n];
		System.out.println("Enter stock values:");
		for(int i=0;i<n;i++)
			p[i]=sc.nextInt();
		int ans=findProfit(n,p);
		System.out.println("The profit is "+ans);
	}
}