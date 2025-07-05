import java.util.*;
class MaxLenWithSame01
{
	static int maxLength(int a[],int n)
	{
		int max=-1;
		int z,o;
		for(int i=0;i<n;i++)
		{
			z=0;o=0;
			for(int j=i;j<n;j++)
			{
				if(a[j]==0)
					z=z+1;
				else
					o=o+1;
				if(o==z)
					max=Math.max(max,(o+z));
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