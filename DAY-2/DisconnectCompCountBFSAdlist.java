import java.util.*;
class DisconnectCompCountBFSAdlist
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
	static int BFS(List<List<Integer>> adj)
	{
		boolean visited[]=new boolean[adj.size()];
		int c=0;
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[i])
			{
				findBFS(i,visited,adj);
				c++;
			}
		}
		return c;
	}
	static void findBFS(int src,boolean visited[],List<List<Integer>> adj)
	{
        	Queue<Integer>q=new LinkedList<>();
		visited[src]=true;
		q.add(src);
		while(!q.isEmpty())
		{
			int curr=q.poll();
			for(int x:adj.get(curr))
			{
				if(!visited[x])
				{
					visited[x]=true;
					q.add(x);
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
		int c=BFS(adj);
		System.out.println("The number of components is "+c);

	}
}
			
	
		
	
			
		