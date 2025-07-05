import java.util.*;
import java.lang.String;

class MEXBrute
{
	static int mex(int n, int a[],int k)
	{
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<=n-k;i++)
		{
			int mex=1;
			TreeSet<Integer> ts=new TreeSet<>();
			for(int j=i;j<i+k;j++)
			{
				ts.add(a[j]);
			}
			for(int x:ts)
			{
				if(x==mex)
				{
					mex++;
				}
				else
				{
					break;
				}	
			}
			ans=Math.max(ans,mex);
		}
		return ans;
	}			
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		int ans=mex(n,a,k);
		System.out.println(ans);
	}
}