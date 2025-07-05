import java.util.*;
import java.io.*;
class MaximumMEXSlide
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		int ans=maxMEX(a,n,k);
		System.out.println(ans);
	}
	public static int maxMEX(int[] a,int n,int k)
	{
		TreeSet<Integer> ts=new TreeSet<>();
		for(int i=1;i<=n+1;i++)
		{
			ts.add(i);
		}
		int i=0,mex=1,ans=Integer.MIN_VALUE,j=0;
		while(j<n)
		{
			if(ts.contains(a[j]))
				ts.remove(a[j]);
				int ws=j-i+1;
				if(ws<k)		j++;
				else if(ws==k)
				{
					mex=ts.first();
					ans=Math.max(ans,mex);
					ts.add(a[i]);
					i++;
					j++;
				}
			
		}
		return ans;
	}
}