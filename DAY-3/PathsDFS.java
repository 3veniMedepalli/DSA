import java.util.*;
class PathsDFS
{

	static ArrayList<ArrayList<Integer>>  bfs(int src,int dest,ArrayList<ArrayList<Integer>>adj)
	{
		Queue<Integer>q=new LinkedList<>();
		 ArrayList<ArrayList<Integer>> res= new ArrayList<>();
		ArrayList<Integer>ans=new ArrayList<Integer>();
		q.add(src);
		while(!q.isEmpty())
		{
			int curr=q.poll();
			ans.add(curr);
			if(curr==dest)
			{	
				res.add(ans);
			}
			for(int x:adj.get(curr))
				q.add(x);
		}
		return res;
	}
	static ArrayList<ArrayList<Integer>> countPaths(int V,int edges[][],int src,int dest)
	{
		ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
		for(int i=0;i<V;i++)
			adj.add(new ArrayList<>());
		for(int i=0;i<edges.length;i++)
		{
			int x=edges[i][0];
			int y=edges[i][1];
			adj.get(x).add(y);
		}
		ArrayList<ArrayList<Integer>>res=bfs(src,dest,adj);
		return res;
		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of vertices:");
		int V=sc.nextInt();
		System.out.println("Enter no of edges:");
		int n=sc.nextInt();
		int edges[][]=new int[n][2];
		for(int i=0;i<n;i++)
			for(int j=0;j<2;j++)
				edges[i][j]=sc.nextInt();
		System.out.println("Enter src:");
		int src=sc.nextInt();
		System.out.println("Enter dest:");
		int dest=sc.nextInt();
		ArrayList<ArrayList<Integer>>res=countPaths(V,edges,src,dest);
		System.out.println(res);
	}
}
		