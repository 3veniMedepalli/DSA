import java.util.*;
class KruskalCycleDetect
{
	static int find(int[] parent,int i)
	{
		if(parent[i]==i)
			return i;
		return(find(parent,parent[i]));
	}
	static void union(int[] parent,int i,int j)
	{
		int i1=find(parent,i);
		int j1=find(parent,j);
		parent[j1]=i1;
	}

	static boolean findCost(int v,int[][]M)
	{
		int[] parent=new int[v+1];
		for(int i=0;i<=v;i++)
			parent[i]=i;
		for(int i=0;i<M.length;i++)
		{
			int x=M[i][0];
			int y=M[i][1];
			if(find(parent,x)==find(parent,y))
				return true;
			union(parent,x,y);
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
		int edges[][]=new int[M][2];
		System.out.println("Enter elements:");
		for(int i=0;i<M;i++)
			for(int j=0;j<2;j++)
				edges[i][j]=sc.nextInt();
		boolean ans=findCost(V,edges);
		System.out.println(ans);
	}
}
