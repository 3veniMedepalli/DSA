import java.util.*;
class FloodFillBFS
{
	static int[][] floodFill(int[][] image,int m,int n,int sr,int sc1,int nc)
	{
		if(image[sr][sc1]==nc)
			return image;
		int old=image[sr][sc1];
		image[sr][sc1]=nc;
		Queue<Integer[]>q=new LinkedList<>();
		q.offer(new Integer[]{sr,sc1});
		int dx[]={0,0,1,-1};
		int dy[]={1,-1,0,0};
		while(!q.isEmpty())
		{
			Integer p[]=q.poll();
			for(int i=0;i<4;i++)
			{
				int x=p[0]+dx[i];
				int y=p[1]+dy[i];
				if(x>=0&&x<m&&y>=0&&y<n&&image[x][y]==old)
				{
					image[x][y]=nc;
					q.offer(new Integer[]{x,y});
				}
			}
		}
		return image;		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter m:");
		int m=sc.nextInt();
		System.out.println("Enter n:");
		int n=sc.nextInt();
		int image[][]=new int[m][n];
		System.out.println("Enter elements:");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				image[i][j]=sc.nextInt();
		System.out.println("Enter sr:");
		int sr=sc.nextInt();
		System.out.println("Enter sc:");
		int sc1=sc.nextInt();
		System.out.println("Enter new color to fill:");
		int nc=sc.nextInt();
		int[][]res=floodFill(image,m,n,sr,sc1,nc);
		for(int[]a:res)
		{
			for(int x:a)
				System.out.print(x+" ");
			System.out.println();
		}
	}
}