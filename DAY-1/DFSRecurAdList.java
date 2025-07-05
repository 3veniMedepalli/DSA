import java.util.*;
class DFSRecurAdList
{
	static void DFS(List<List<Integer>> adj, boolean visited[],int src)
 	{
        	System.out.print(src+ " ");
        	visited[src]=true;
        	for(Integer x:adj.get(src))
		{
            		if(!visited[x])
                		DFS(adj,visited,x);
        	}
  	}
	static void addEdge(List<List<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
	static void display(List<List<Integer>> adj)
	{
		int i=0;
		for(List<Integer>r:adj)
		{
			System.out.print(i+":");
			for(Integer x:r)
			{
				System.out.print(x+" ");
			}
			System.out.println();
			i++;
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		List<List<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++)
				adj.add(i,new ArrayList<>());
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
		display(adj);
		System.out.println("Enter src node:");
		int src=sc.nextInt();
		boolean visited[]=new boolean[n];
		DFS(adj,visited,src);
	}
}