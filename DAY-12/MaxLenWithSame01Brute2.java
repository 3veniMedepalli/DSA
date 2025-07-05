import java.util.*;
class MaxLenWithSame01Brute2
{
	static int maxLength(int a[],int n)
	{
		int max=-1;
		int s=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				if(a[j]==0)
					s=s-1;
				else
					s=s+1;
				if(s==0)
					max=Math.max(max,j-i+1);
			}
		}
		return max;
	}
				
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter elements:");
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int ans=maxLength(a,n);
		System.out.println("The max length is "+ans);
	}
}