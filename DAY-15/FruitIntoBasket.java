import java.util.*;
class FruitIntoBasket
{

	static int collect(int n,int a[])
	{
		HashMap<Integer,Integer>hm=new HashMap<>();
		int max=-1;
		int i=0,j=0;
		while(j<n)
		{
			if(hm.size()>2)
			{
				hm.put(a[i],hm.getOrDefault(a[i],0)-1);
				if(hm.get(a[i])==0)
					hm.remove(a[i]);
				i++;
			}
			if(!hm.containsKey(a[j]))
				hm.put(a[j],1);
			else
				hm.put(a[j],hm.getOrDefault(a[j],0)+1);
			max=Math.max(max,(j-i+1));
			j++;
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
		int ans=collect(n,f);
		System.out.println("The maximum fruits can be collected is "+ans);
	}
}
