import java.util.*;
class ChocolateDistribute
{
	static int find(int[] a,int n,int m)
	{
		int min=Integer.MAX_VALUE;
		Arrays.sort(a);
		for(int i=0;i<=n-m;i++)
		 {
            		int diff=a[i+m-1]-a[i]; 
	            	min=Math.min(min,diff);
		}

        return min;
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int m=sc.nextInt();
		System.out.println("The ans is "+find(arr,n,m));
	}
}