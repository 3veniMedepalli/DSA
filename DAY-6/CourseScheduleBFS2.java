import java.util.*;
class CourseScheduleBFS2
{
	static void addEdge(ArrayList<ArrayList<Integer>> adj,int i,int j)
	{
		adj.get(j).add(i);
	}	
	static boolean findTopo(int v,ArrayList<ArrayList<Integer>> adj)
	{
		Queue<Integer>q=new LinkedList<>();
		int[] ind=new int[v];
		for(int i=0;i<v;i++)
		{
			for(int x:adj.get(i))
				ind[x]++;
		}
		for(int i=0;i<v;i++)
		{
			if(ind[i]==0)
				q.add(i);
		}
		int[] res=new int[v];
		int k=0;
		while(!q.isEmpty())
		{
			int x=q.poll();
			res[k++]=x;	
			for(int a:adj.get(x))
			{
				ind[a]--;
				if(ind[a]==0)
					q.add(a);
			}
		}
		if(k!=v)
			return false;
		return true;
			
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

		System.out.print(findTopo(V,adj));
	}
}
