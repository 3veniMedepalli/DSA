import java.util.*;
class DisconnectCompAdlistBfs
{
	static void addEdge(List<List<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
	static List<List<Integer>> BFS(List<List<Integer>> adj)
	{
		boolean visited[]=new boolean[adj.size()];
		List<List<Integer>>res=new ArrayList<>();
		for(int i=0;i<adj.size();i++)
		{
			if(!visited[i])
			{
				List<Integer>ans=new ArrayList<>();
				findBfs(i,visited,adj,ans);
				res.add(ans);
			}
		}
		return res;
	}
	static void findBfs(int src,boolean visited[],List<List<Integer>> adj,List<Integer> ans)
	{
		Queue<Integer>q=new LinkedList<>();
		visited[src]=true;
		q.add(src);
		while(!q.isEmpty())
		{
			int curr=q.poll();
			ans.add(curr);
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
		List<List<Integer>>res=BFS(adj);
		for(int i=0;i<res.size();i++)
		{
			System.out.println((i+1)+":"+res.get(i));
		}
	}
}
			
			
