import java.util.*;
class CycleDetectBFS
{
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		//adj.get(j).add(i);
	}
	static boolean bfs(int s,ArrayList<ArrayList<Integer>> adj,boolean visited[])
	{
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[]{s,-1});
		visited[s]=true;
		while(!q.isEmpty())
		{
			int p[]=q.poll();
			int x=p[0];
			int y=p[1];
			for(int x1:adj.get(x))
			{
				if(!visited[x1])
				{
					visited[x1]=true;
					q.add(new int[]{x1,x});
				}
				else if(x1==y)
					return true;
			}
		}
		return false;	
	}
			
		
	static boolean findCycle(int v,	ArrayList<ArrayList<Integer>> adj)
	{
		boolean visited[]=new boolean[v];
		for(int i=0;i<v;i++)
		{
			if(!visited[i]&&bfs(i,adj,visited))
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
