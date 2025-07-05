import java.util.*;
class DFS
{
  static void DFS(int a[][], boolean visited[],int src)
 {
        Stack<Integer>st=new Stack<>();
	st.push(src);
        visited[src]=true;
      	while(!st.isEmpty())
	{
		int curr=st.pop();
		System.out.print(curr+" ");
		for(int i=0;i<a.length;i++)
		{
			if(a[curr][i]==1 && !visited[i])
			{
				st.push(i);
				visited[i]=true;
			}
		}
	}
			
  }
 static void addEdge(int[][] M,int i,int j)
	{
		M[i][j]=1;
		M[j][i]=1;
	}
	static void display(int[][] M)
	{
		for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				System.out.print(M[i][j]);
			}
			System.out.println();
		}
				
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int n=sc.nextInt();
		int[][] M=new int[n][n];
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
		System.out.println("Enter start node:");
		int src=sc.nextInt();
		boolean visited[]=new boolean[n];
		display(M);
		DFS(M,visited,src);
	}
}
