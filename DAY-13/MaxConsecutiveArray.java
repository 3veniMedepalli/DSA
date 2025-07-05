import java.util.*;
class MaxConsecutiveArray
{
	static int find(int n,int[] num)
	{
		Arrays.sort(num);
		int ans=1;
		for(int i=0;i<n-1;i++)
		{
			if(num[i]+1==num[i+1])
				ans++;
			else
				ans=1;
		}
		return ans;		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter numbers:");
		int num[]=new int[n];
		for(int i=0;i<n;i++)
			num[i]=sc.nextInt();
		int ans=find(n,num);
		System.out.println("The maximum is "+ans);
	}
}