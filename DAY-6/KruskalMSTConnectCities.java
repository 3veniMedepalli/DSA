import java.util.*;
class KruskalMSTConnectCities
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

	static int findCost(int v,int[][]M)
	{
		int[] parent=new int[v+1];
		for(int i=0;i<=v;i++)
			parent[i]=i;
		int cost=0,count=0;
		Arrays.sort(M,(x,y)->x[2]-y[2]);
		for(int i=0;i<M.length;i++)
		{
			int x=M[i][0];
			int y=M[i][1];
			int z=M[i][2];
			if(find(parent,x)!=find(parent,y))
			{
				union(parent,x,y);
				cost+=z;
				count++;
				if(count==v-1)
					break;
			}
		}
		int s=find(parent,1);
		for(int i=2;i<=v;i++)
			if(find(parent,i)!=s)
				return -1;
		return cost;
	}
				
			
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter V:");
		int V=sc.nextInt();
		System.out.println("Enter M:");
		int M=sc.nextInt();
		int edges[][]=new int[M][3];
		System.out.println("Enter elements:");
		for(int i=0;i<M;i++)
			for(int j=0;j<3;j++)
				edges[i][j]=sc.nextInt();
		int ans=findCost(V,edges);
		System.out.println(ans);
	}
}
