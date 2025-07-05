import java.util.*;
class GraphHashMap
{
	static void addEdge(HashMap<Integer,List<Integer>> adj,int i,int j)
	{
		adj.get(i).add(j);
		//adj.get(j).add(i);
	}
	static void display(HashMap<Integer,List<Integer>> adj)
	{
		for(Map.Entry<Integer,List<Integer>> r: adj.entrySet())
		{
			System.out.print(r.getKey()+":");
			for(Integer x:r.getValue())
			{
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		HashMap<Integer,List<Integer>>adj=new HashMap<>();
		for(int i=0;i<n;i++)
				adj.put(i,new ArrayList<>());
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
		display(adj);
	}
}
			
	
		
	
			
		