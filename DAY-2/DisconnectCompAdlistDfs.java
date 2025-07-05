import java.util.*;
class DisconnectCompAdlistDfs
{
	static void addEdge(List<List<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
	static List<List<Integer>> DFS(List<List<Integer>> adj)
	{
		boolean visited[]=new boolean[adj.size()];
		List<List<Integer>>res=new ArrayList<>();
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[i])
			{
				List<Integer>ans=new ArrayList<>();
				findDfs(i,visited,adj,ans);
				res.add(ans);
			}
		}
		return res;
	}
	static void findDfs(int src,boolean visited[],List<List<Integer>> adj,List<Integer> ans)
	{
		visited[src]=true;
		ans.add(src);		
		for(int x:adj.get(src))
		{
			if(!visited[x])
			{
				findDfs(x,visited,adj,ans);
			}
		}
	}
	static void display(List<List<Integer>> adj)
	{
		for(List<Integer>r:adj)
		{
			for(int x:r)
			{
				System.out.print(x+" ");
			}
			System.out.println();
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
		List<List<Integer>>res=DFS(adj);
		for(int i=0;i<res.size();i++)
		{
			System.out.println((i+1)+":"+res.get(i));
		}
	}
}
			
			
