import java.util.*;
class KruskalMSTConnectHouses
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

	static int findCost(int v,ArrayList<int[]>M)
	{
		int[] parent=new int[v+1];
		for(int i=0;i<=v;i++)
			parent[i]=i;
		int cost=0,count=0;
		Collections.sort(M,(x,y)->x[2]-y[2]);
		for(int a[]:M)
		{
			int x=a[0];
			int y=a[1];
			int z=a[2];
			if(find(parent,x)!=find(parent,y))
			{
				union(parent,x,y);
				cost+=z;
				count++;
				if(count==v-1)
					break;
			}
		}
		return cost;
	}
				
			
	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		int points[][]=new int[n][2];
		System.out.println("Enter elements:");
		for(int i=0;i<n;i++)
			for(int j=0;j<2;j++)
				points[i][j]=sc.nextInt();
		ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
		for(int i=0;i<n;i++)
			adj.add(new ArrayList<>());
		ArrayList<int[]>edges=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j)
				{
					int[]x=points[i];
					int[]y=points[j];
					int dist=(int)Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
					edges.add(new int[]{i,j,dist});
				}
			}
		}
		int ans=findCost(n,edges);
		System.out.println(ans);
	}
}
