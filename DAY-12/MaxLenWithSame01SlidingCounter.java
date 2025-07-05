import java.util.*;
class MaxLenWithSame01SlidingCounter
{
	static int maxLength(int a[],int n)
	{
		int res=0;
		int o=0,z=0;
		HashMap<Integer,Integer>hm=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(a[i]==0)
				z=z+1;
			else
				o=o+1;
			if(z==o)
				res=i+1;
			if(hm.containsKey(z-o))
				res=Math.max(res,i-hm.get(z-o));
			else
				hm.put((z-o),i);
		}
		return res;
				
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