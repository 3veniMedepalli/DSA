import java.util.*;
class Celebrity
{
	static int celebrity(int[][]mat,int n)
	{
		int ind[]=new int[n];
		int outd[]=new int[n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(mat[i][j]==1&&i!=j)
				{
					ind[j]++;
					outd[i]++;
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			if(ind[i]==n-1&&outd[i]==0)
				return i;
		}
		return -1;
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of persons:");
		int n=sc.nextInt();
		int mat[][]=new int[n][n];
		System.out.println("Enter elements:");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i][j]=sc.nextInt();
			}
		}
		int t=celebrity(mat,n);
		if(t!=-1)
			System.out.println("The celebrity is "+t);
		else
			System.out.println("no celebrity");
	}
}
			
	