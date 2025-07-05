import java.util.*;
class ConnectEmployeeDSU
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
	static int getTotal(int[] parent,int[]size,int x)
	{
		return size[find(parent,x)];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of companies:");
		int n=sc.nextInt();
		System.out.println("Enter number of queries:");
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
		for(int i=1;i<=q;i++)
		{
			String ch[]=sc.nextLine().split(" ");
			if(ch[0].equals("Q"))
			{
				int ans=getTotal(parent,s,Integer.parseInt(ch[1]));
				System.out.println("The size is "+ans);
			}
			else
			{
				int a=Integer.parseInt(ch[1]);
				int b=Integer.parseInt(ch[2]);
				union(parent,s,a,b);
			}
		}
	}
}