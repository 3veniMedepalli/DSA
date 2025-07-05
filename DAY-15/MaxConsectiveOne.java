import java.util.*;
class MaxConsectiveOne
{

	static int maxConsectiveOne(int n,int nums[],int k)
	{
		int i=0,j=0,z=0;
        	int max=-1;
        	while(i<n)
        	{
           		 if(nums[i]==0)
                		z++;
            		while(z>k)
            		{
                		if(nums[j]==0)
                    		z--;
                		j++;
            		}
            		max=Math.max(max,i-j+1);
            		i++;
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
		System.out.println("Enter k:");
		int k=sc.nextInt();
		int ans=maxConsectiveOne(n,f,k);
		System.out.println("The maximum fruits can be collected is "+ans);
	}
}
