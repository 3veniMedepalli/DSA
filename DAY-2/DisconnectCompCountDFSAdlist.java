import java.util.*;
class DisconnectCompCountDFSAdlist
{
	static void addEdge(List<List<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
	static void display(List<List<Integer>> adj)
	{
		for(List<Integer>r:adj)
		{
			for(Integer x:r)
			{
				System.out.print(x);
			}
			System.out.println();
		}
	}
	static int DFS(List<List<Integer>> adj)
	{
		boolean visited[]=new boolean[adj.size()];
		int c=0;
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[i])
			{
				findDFS(i,visited,adj);
				c++;
			}
		}
		return c;
	}
	static void findDFS(int src,boolean visited[],List<List<Integer>> adj)
	{
        	visited[src]=true;
        	for(Integer x:adj.get(src))
		{
            		if(!visited[x])
                		findDFS(x,visited,adj);
        	}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++)
				adj.add(new ArrayList<>());
		while(true)
		{
			System.out.println("Enter vertices for edge:");
			int u=sc.nextInt();
			int v=sc.nextInt();
			addEdge(adj,u,v);
			System.out.println("Enter -1 to quit");
			int x=sc.nextInt();
			if(x==-1)
				break;
		}
		//display(adj);
		int c=DFS(adj);
		System.out.println("The number of components is "+c);

	}
}
			
	
		
	
			
		