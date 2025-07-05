import java.util.*;
class MaxLenWithSame01SlidingSum
{
	static int maxLength(int a[],int n)
	{
		int res=0;
		int s=0;
		HashMap<Integer,Integer>hm=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(a[i]==0)
				s=s-1;
			else
				s=s+1;
			if(s==0)
				res=i+1;
			if(hm.containsKey(s))
				res=Math.max(res,i-hm.get(s));
			else
				hm.put(s,i);
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