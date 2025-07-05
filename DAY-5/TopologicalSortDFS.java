import java.util.*;
class TopologicalSortDFS
{
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
	}
	static void dfs(ArrayList<ArrayList<Integer>> adj,int s,boolean visited[],Stack<Integer>st)
	{
		visited[s]=true;
		for(int x:adj.get(s))
		{
			if(!visited[x])
				dfs(adj,x,visited,st);
		}
		st.push(s);
	}	
	static int[] findTopo(int v,ArrayList<ArrayList<Integer>> adj)
	{
		boolean visited[]=new boolean[v];
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<v;i++)
		{
			if(!visited[i])
				dfs(adj,i,visited,st);
		}
		int res[]=new int[v];
		int k=0;
		while(!st.isEmpty())
			res[k++]=st.pop();
		return res;
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

		int[] ans=findTopo(V,adj);
		for(int x:ans)
			System.out.print(x+" ");
	}
}
