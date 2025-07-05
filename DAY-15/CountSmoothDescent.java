import java.util.*;
class CountSmoothDescent
{

	static int countSmoothDescent(int n,int a[])
	{
		int count=1;
		int i=0,j=0;
		while(j<n-1)
		{
			if(a[j]==(a[j+1]+1))
			{
				j++;
				count+=(j-i+1);
			}
			else
			{
				
				count=count+1;
				j++;
				i=j;
			}
		}
		return count;
		
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
		int ans=countSmoothDescent(n,f);
		System.out.println("The maximum fruits can be collected is "+ans);
	}
}
