import java.util.*;
class EarliestTimeFriend
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
	static int earliestTime(ArrayList<int[]>a,int n)
	{
		int[] parent =new int[n];
		for(int i=0;i<n;i++)
			parent[i]=i;
		Collections.sort(a,(x,y)->x[2]-y[2]);
		for(int a1[]:a)
		{
			int x=a1[0];
			int y=a1[1];
			int t=a1[2];
			if(find(parent,x)!=find(parent,y))
			{
				union(parent,x,y);
				n--;
			}
			if(n==1)
				return t;
		}
		return -1;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of persons:");
		int n=sc.nextInt();
		System.out.println("Enter no of relations:");
		int m=sc.nextInt();
		ArrayList<int[]>a=new ArrayList<>();
		System.out.println("Enter relations:");
		for(int i=0;i<m;i++)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			int t=sc.nextInt();
			a.add(new int[]{x,y,t});
		}
		int t=earliestTime(a,n);
		if(t!=-1)
			System.out.println("The earliest time to become frnds is "+t);
		else
			System.out.println("cannot be frnds");
	}
}
			
	