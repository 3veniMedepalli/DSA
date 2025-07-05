import java.util.*;
class CanVisitAllVertexUseCountBFS1
{
	static int c;
	static boolean canVisit(ArrayList<Integer> adj[],int x)
	{
		int n=adj.length;
		boolean visited[]=new boolean[n];
		findBfs(visited,adj,x);
		if(c==n)
		{
			return true;
		}
		return false;
			
	}
	static void findBfs(boolean visited[],ArrayList<Integer> adj[],int st)
	{
		Queue<Integer>q=new LinkedList<>();
		visited[st]=true;
		while(!q.isEmpty())
		{
			int curr=q.poll();
			c++;
			for(int x:adj[st])
			{
				if(!visited[x])
				{
					q.add(x);
                    			visited[x]=true;
				}
			}
		}

	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		ArrayList<Integer> a[]=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter no of vertex connectes to "+(i));
			int co=sc.nextInt();
			ArrayList<Integer>arr=new ArrayList<>();
			System.out.println("enter vertexes");
			for(int j=0;j<co;j++)
			{
				arr.add(sc.nextInt());
			}
			a[i]=arr;
		}	
		System.out.println("Enter start vertex");
		int x=sc.nextInt();
		System.out.println(canVisit(a,x));
	}
}
			
			
