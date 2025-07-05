import java.util.*;
class NCandyKPeople
{
	static int[] find(int n,int k)
	{
		int ans[]=new int[k];
		int i=0;
		int c=0;
		while(n>0)
		{
			c=Math.min(c+1,n);
			if(c<=n)
			{
				ans[i]=ans[i]+c;
			}
			n=n-c;
			if(i==k-1&&n>0)
				i=0;
			else
				i++;
		}
		return ans;
			

				
	}
			
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of candies:");
		int n=sc.nextInt();
		System.out.println("Enter people:");
		int k=sc.nextInt();
		int[] ans=find(n,k);
		for(int x:ans)
			System.out.print(x+" ");
	}
}