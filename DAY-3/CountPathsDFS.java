import java.util.*;
class CountPathsDFS
{
	static int dfs(int src,int dest,ArrayList<ArrayList<Integer>>adj)
	{
		if(src==dest)
			return 1;
		int c=0;
		for(int x:adj.get(src))
		{
			c=c+dfs(x,dest,adj);
		}
		return c;
	}
	static int countPaths(int V,int edges[][],int src,int dest)
	{
		ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<>());
		for(int i=0;i<edges.length;i++)
		{
			int x=edges[i][0];
			int y=edges[i][1];
			adj.get(x).add(y);
		}
		int ans=dfs(src,dest,adj);
		return ans;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of vertices:");
		int V=sc.nextInt();
		System.out.println("Enter no of edges:");
		int n=sc.nextInt();
		int edges[][]=new int[n][2];
		for(int i=0;i<n;i++)
			for(int j=0;j<2;j++)
				edges[i][j]=sc.nextInt();
		System.out.println("Enter src:");
		int src=sc.nextInt();
		System.out.println("Enter dest:");
		int dest=sc.nextInt();
		int ans=countPaths(V,edges,src,dest);
		System.out.println("The total no of paths are "+ans);
	}
}
		