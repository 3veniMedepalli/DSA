import java.util.*;
class FloodFillDFSRecur
{
	static void dfs(int[][] image,int m,int n,int sr,int sc1,int old,int nc)
	{
		if(sr<0||sr>=m||sc1<0||sc1>=n||image[sr][sc1]!=old)
			return;
		image[sr][sc1]=nc;
		dfs(image,m,n,sr+1,sc1,old,nc);
		dfs(image,m,n,sr-1,sc1,old,nc);
		dfs(image,m,n,sr,sc1+1,old,nc);
		dfs(image,m,n,sr,sc1-1,old,nc);
	}
	static int[][] floodFill(int[][] image,int m,int n,int sr,int sc1,int nc)
	{
		if(image[sr][sc1]==nc)
			return image;
		int old=image[sr][sc1];
		dfs(image,m,n,sr,sc1,old,nc);
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