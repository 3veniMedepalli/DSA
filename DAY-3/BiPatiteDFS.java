import java.util.*;
class BiPatiteDFS
{
	static Boolean dfs(int s,int color,int[] colors,ArrayList<ArrayList<Integer>>adj)
	{
		colors[s]=color;
		for(int x:adj.get(s))
		{
			if(colors[x]==-1)
			{
				if(dfs(x,1-color,colors,adj)==false)
					return false;
			}
			if(colors[x]==colors[s])
				return false;
		}
		return true;
	}
	static Boolean isParite(int v,ArrayList<ArrayList<Integer>>adj)
	{
		int []colors=new int[v];
		Arrays.fill(colors,-1);
		for(int i=0;i<v;i++)
		{
			if(colors[i]==-1)
			{
				if(dfs(i,0,colors,adj)==false)
					return false;
			}
		}	
		return true;
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
		ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<>());
		for(int i=0;i<edges.length;i++)
		{
			int x=edges[i][0];
			int y=edges[i][1];
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
		if(isParite(V,adj))
			System.out.println("The graph is biparite");
		else
			System.out.println("Not bipartite");
	}
}
		