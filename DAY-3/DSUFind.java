import java.util.*;
class DSUFind
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
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of persons:");
		int n=sc.nextInt();
		System.out.println("Enter number of relations:");
		int e=sc.nextInt();
		int[] parent=new int[n];
		for(int i=0;i<n;i++)
			parent[i]=i;
		System.out.println("Enter relations:");
		for(int i=0;i<e;i++)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			union(parent,x,y);
		}
		System.out.println("Enter query:");
		int s1=sc.nextInt();
		int s2=sc.nextInt();
		System.out.println((find(parent,s1)==find(parent,9s2)));
	}
}
			
		