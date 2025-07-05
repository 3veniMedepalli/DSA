import java.util.*;
class DisconnectCompCountDFSAdMatrix
{
	static void addEdge(int[][]M,int i,int j)
	{
		M[i][j]=1;
		M[j][i]=1;
	}
	static void display(int[][]M)
	{
		for(int[]r:M)
		{
			for(int x:r)
			{
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	static int getComp(int[][]M)
	{
		boolean visited[]=new boolean[M.length];
		int c=0;
		for(int i=0;i<M.length;i++)
		{
			if(!visited[i])
			{
				findDFS(i,visited,M);
				c++;
			}
		}
		return c;
						
	}
	static void findDFS(int src,boolean visited[],int[][]M)
	{
        	visited[src]=true;
        	for(int i=0;i<M.length;i++)
		{
            		if(M[src][i]==1 && !visited[i])
                		findDFS(i,visited,M);
        	}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		int[][]M=new int[n][n];
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
		//display(adj);
		int c=getComp(M);
		System.out.println("The number of components is "+c);

	}
}
			
	
		
	
			
		