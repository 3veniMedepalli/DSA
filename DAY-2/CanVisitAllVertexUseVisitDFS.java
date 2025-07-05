import java.util.*;
class CanVisitAllVertexUseVisitDFS
{
	static void addEdge(List<List<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
	static boolean canVisit(List<List<Integer>> adj,int x)
	{
		int n=adj.size();
		boolean visited[]=new boolean[n];
		findDfs(visited,adj,x);
		for(int i=0;i<n;i++)
		{
			if(visited[i]==false)
				return false;
		}
		return true;
			
	}
	static void findDfs(boolean visited[],List<List<Integer>> adj,int st)
	{
		visited[st]=true;		
		for(int x:adj.get(st))
		{
			if(!visited[x])
			{
				findDfs(visited,adj,x);
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		List<List<Integer>>adj=new ArrayList<>();
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
			adj.add(new ArrayList<>());
		while(true)
		{
			System.out.println("Enter vertices to add edges:");
			int u=sc.nextInt();
			int v=sc.nextInt();
			addEdge(adj,u,v);
			System.out.println("Enter -1 to quit");
			int x=sc.nextInt();
			if(x==-1)
				break;
		
		}
		System.out.println("Enter start vertex");
		int x=sc.nextInt();
		System.out.println(canVisit(adj,x));
	}
}
			
			
