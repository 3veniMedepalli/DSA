import java.util.*;
class EquationSatisfyCheck
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

	static boolean check(String a[],int n)
	{
		HashSet<Character>h=new HashSet<>();
		for(String x:a)
		{
			for(char ch:x.toCharArray())
				if(ch!='='&&ch!='!')
					h.add(ch);
		}
		int parent[]=new int[h.size()];
		for(int i=0;i<n;i++)
		{
			String s=a[i];
			if(s.charAt(1)=='=')
				union(parent,s.charAt(0)-'a',s.charAt(3)-'a');
			else
			{
				if(find(parent,s.charAt(0)-'a')==find(parent,s.charAt(3)-'a'))
					return false;
			}
		}
		return true;
		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter Equations:");
		String a[]=new String[n];
		for(int i=0;i<n;i++)
			a[i]=sc.next();
		if(check(a,n))
			System.out.println("The equations are satisfied");
		else
			System.out.println("The equations are not satisfied");
	}
}
			