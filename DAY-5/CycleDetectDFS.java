import java.util.*;
class CycleDetectDFS
{
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		//adj.get(j).add(i);
	}
	static boolean dfs(int s,ArrayList<ArrayList<Integer>> adj,boolean visited[],boolean recStack[])
	{
		if(recStack[s]==true)
			return true;
		if(visited[s]==true)
			return false;
		visited[s]=true;
		recStack[s]=true;
		for(int x:adj.get(s))
		{
			if(dfs(x,adj,visited,recStack))
				return true;
		}
		recStack[s]=false;
		return false;
	}
			
		
	static boolean findCycle(int v,	ArrayList<ArrayList<Integer>> adj)
	{
		boolean visited[]=new boolean[v];
		boolean recStack[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i]&&dfs(i,adj,visited,recStack))
				return true;
		}
		return false;
	}		
			
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter V:");
		int V=sc.nextInt();
		System.out.println("Enter M:");
		int M=sc.nextInt();
		ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
		for(int i=0;i<M;i++)
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

		boolean ans=findCycle(V,adj);
		System.out.println(ans);
	}
}
