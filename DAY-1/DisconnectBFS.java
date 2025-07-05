import java.util.*;
class DisconnectBFS
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
	static void BFS(List<List<Integer>> adj)
	{
		boolean visited[]=new boolean[adj.size()];
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[i])
				findBFS(i,visited,adj);
		}
	}
	static void findBFS(int start,boolean visited[],List<List<Integer>> adj)
	{
		Queue<Integer>q=new LinkedList<>();
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty())
		{
			int curr=q.poll();
			System.out.print(curr+" ");
			for(int x:adj.get(curr))
			{
				if(!visited[x])
				{
					q.add(x);
					visited[x]=true;
				}
			}
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
		//display(adj);
		BFS(adj);
	}
}
			
	
		
	
			
		