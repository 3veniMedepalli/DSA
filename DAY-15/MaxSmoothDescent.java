import java.util.*;
class MaxSmoothDescent
{

	static int maxSmoothDescent(int n,int a[])
	{
		int count=1;
		int i=0,j=0;
		int max=-1;
		while(j<n-1)
		{
			if(a[j]==(a[j+1]+1))
			{
				j++;
				count+=1;
				max=Math.max(max,count);
			}
			else
			{
				
				count=1;
				max=Math.max(max,count);
				j++;
				i=j;
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
		int f[]=new int[n];
		for(int i=0;i<n;i++)
			f[i]=sc.nextInt();
		int ans=maxSmoothDescent(n,f);
		System.out.println("The maximum is "+ans);
	}
}
