import java.util.*;
class DSUDisconnectCompCount
{
	static int findGroup(int[] parent)
	{
		int c=0;
		for(int i=0;i<parent.length;i++)
		{
			if(find(parent,i)==i)
				c++;
		}
		return c;
	}
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
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		System.out.println("Enter number of edges:");
		int e=sc.nextInt();
		int[] parent=new int[n];
		for(int i=0;i<n;i++)
			parent[i]=i;
		System.out.println("Enter edges:");
		for(int i=0;i<e;i++)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			union(parent,x,y);
		}
		System.out.println("The number of components are "+findGroup(parent));
	}
}
			
		