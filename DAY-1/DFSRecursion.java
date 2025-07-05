import java.util.*;
class DFSRecursion
{
  static void DFS(int a[][], boolean visited[],int src)
 {
        System.out.print(src+ " ");
        visited[src]=true;
        for (int j=0;j<a.length;j++)
	{
            if(a[src][j]==1&&!visited[j])
                DFS(a,visited,j);
        }
  }
 static void addEdge(int[][] M,int i,int j)
	{
		M[i][j]=1;
		M[j][i]=1;
	}
	static void display(int[][] M)
	{
		for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				System.out.print(M[i][j]);
			}
			System.out.println();
		}
				
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		int[][] M=new int[n][n];
		while(true)
		{
			System.out.println("Enter vertices for edge:");
			int u=sc.nextInt();
			int v=sc.nextInt();
			addEdge(M,u,v);
			System.out.println("Enter -1 to quit");
			int x=sc.nextInt();
			if(x==-1)
				break;
		}
		System.out.println("Enter start node:");
		int src=sc.nextInt();
		boolean visited[]=new boolean[n];
		display(M);
		DFS(M,visited,src);
	}
}
