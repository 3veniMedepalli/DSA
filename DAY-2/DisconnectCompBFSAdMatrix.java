import java.util.*;
class DisconnectCompBFSAdMatrix
{
	static void addEdge(int[][]M,int i,int j)
	{
		M[i][j]=1;
		M[j][i]=1;
	}
	static void display(int[][]M)
	{
		for(int[]r:M)
		{
			for(int x:r)
			{
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
	static List<List<Integer>> getComp(int[][]M)
	{
		boolean visited[]=new boolean[M.length];
		int c=0;
		List<List<Integer>>res=new ArrayList<>();
		for(int i=0;i<M.length;i++)
		{
			if(!visited[i])
			{
				List<Integer>ans=new ArrayList<>();
				findBFS(i,visited,M,ans);
				res.add(ans);
			}
		}
		return res;
						
	}
	static void findBFS(int src,boolean visited[],int[][]M,List<Integer>ans)
	{
        	Queue<Integer>q=new LinkedList<>();
		visited[src]=true;
		q.add(src);
		while(!q.isEmpty())
		{
			int curr=q.poll();
			ans.add(curr);
			for(int i=0;i<M.length;i++)
			{
				if(M[src][i]==1 && !visited[i])
				{
					visited[i]=true;
					q.add(i);
				}
			}
		}

	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		int[][]M=new int[n][n];
		while(true)
		{
			System.out.println("Enter vertices for edge:");
			int u=sc.nextInt();
			int v=sc.nextInt();
			addEdge(M,u,v);
			System.out.println("Enter -1 to quit");
			int x=sc.nextInt();
			if(x==-1)
				break;
		}
		List<List<Integer>>res=getComp(M);
		for(int i=0;i<res.size();i++)
		{
			System.out.println((i+1)+":"+res.get(i));
		}

	}
}
			
	
		
	
			
		