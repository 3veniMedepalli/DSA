import java.util.*;
class FindDiffAfterQueryDSU
{
	
	static int find(int[] parent,int i)
	{
		if(parent[i]==i)
			return i;
		return(find(parent,parent[i]));
	}
	static void union(int[] parent,int[] size,int i,int j)
	{
		int i1=find(parent,i);
		int j1=find(parent,j);
		if(i1!=j1)
		{
			parent[j1]=i1;
			size[i1]=size[i1]+size[j1];
		}
	}
	static int findSize(int[] parent,int[] size)
	{
		ArrayList<Integer> ans=new ArrayList<Integer>();
		for(int i=1;i<parent.length;i++)
		{
			if(find(parent,i)==i)
				ans.add(size[i]);
		
		}
		Collections.sort(ans);
		if(ans.size()==1)
			return 0;
		return (ans.get(ans.size()-1))-ans.get(0);
		
		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter N:");
		int n=sc.nextInt();
		System.out.println("Enter M(edges):");
		int q=sc.nextInt();
		sc.nextLine();
		int[] parent=new int[n+1];
		int[] s=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			parent[i]=i;
			s[i]=1;
		}
		System.out.println("Enter queries:");
		for(int i=0;i<q;i++)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			union(parent,s,x,y);
			int ans=findSize(parent,s);
			System.out.println(ans);
		}
	}
}