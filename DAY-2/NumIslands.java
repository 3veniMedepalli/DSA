import java.util.*;
class NumIslands
{
	static int numIsland(char[][]M,int n,int m)
	{
	
		int c=0;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(M[i][j]=='1')
				{
					dfs(i,j,n,m,M);
					c++;
				}
			}
		}
		return c;
								
	}
	static void dfs(int i,int j,int n,int m,char[][]M)
	{
		if(i<0||i>=n||j<0||j>=m)
			return;
		if(M[i][j]=='1')
		{
			M[i][j]='#';
			dfs(i-1,j,n,m,M);
			dfs(i,j-1,n,m,M);
			dfs(i+1,j,n,m,M);
			dfs(i,j+1,n,m,M);
		}
		else
			return;
			       	
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter m:");
		int m=sc.nextInt();
		char[][]M=new char[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				M[i][j]=sc.next().charAt(0);
			}
		}
		int c=numIsland(M,n,m);
		System.out.println("The number of islands are "+c);

	}
}
			
	
		
	
			
		