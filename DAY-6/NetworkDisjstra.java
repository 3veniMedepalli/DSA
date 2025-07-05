import java.util.*;
class NetworkDisjstra
{
	static int dijstra(int n,int[][] edges,int src)
	{
		ArrayList<ArrayList<ArrayList<Integer>>>adj=new ArrayList<>();
		for(int i=0;i<n;i++)
			adj.add(new ArrayList<>());
		for(int i=0;i<edges.length;i++)
		{
			int u=edges[i][0];
			int v=edges[i][1];
			int w=edges[i][2];
			ArrayList<Integer>e1=new ArrayList<>();
			e1.add(v);
			e1.add(w);
			adj.get(u).add(e1);
		}
		PriorityQueue<ArrayList<Integer>>pq=new PriorityQueue<>(Comparator.comparingInt(a->a.get(0)));
		int dist[]=new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src]=0;
		ArrayList<Integer>start=new ArrayList<>();
		start.add(0);
		start.add(src);
		pq.offer(start);
		while(!pq.isEmpty())
		{
			ArrayList<Integer>c=pq.poll();
			int d=c.get(0);
			int u=c.get(1);
			for(ArrayList<Integer>x:adj.get(u))
			{
				int v=x.get(0);
				int w=x.get(1);
				if(dist[v]>dist[u]+w)
				{
					dist[v]=dist[u]+w;
					ArrayList<Integer>t=new ArrayList<>();
					t.add(dist[v]);
					t.add(v);
					pq.offer(t);
				}
			}
		}
		int max=-1;
		for(int x:dist)
		{
			if(x==Integer.MAX_VALUE)
				return -1;
			else if(x>max)
				max=x;
		}
		return max;

				
	}
			
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter v:");
		int v=sc.nextInt();
		System.out.println("enter no of edges:");
		int m=sc.nextInt();
		int edges[][]=new int[m][3];
		for(int i=0;i<m;i++)
			for(int j=0;j<3;j++)
				edges[i][j]=sc.nextInt();
		System.out.println("Enter src:");
		int src=sc.nextInt();
		int res=dijstra(v,edges,src);
		System.out.println(res);
		
			
	}
}