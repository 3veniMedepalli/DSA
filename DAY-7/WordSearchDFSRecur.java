import java.util.*;
class WordSearchDFSRecur
{
	static boolean dfs(int[][] image,int m,int n,int sr,int sc1,String str,int k)
	{
		if(sr<0||sr>=m||sc1<0||sc1>=n)
			return false;
		if(image[sr][sc1]==str.charAt(k))
				return true;
		dfs(image,m,n,sr+1,sc1,str,nc);
		dfs(image,m,n,sr-1,sc1,str,nc);
		dfs(image,m,n,sr,sc1+1,str,nc);
		dfs(image,m,n,sr,sc1-1,str,nc);
		k++;
	}
	static boolean exists(char[][] image,int m,int n,int str)
	{
		int k=1;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(image[i][j]==str.charAt(0))
				{
					if(dfs(image,m,n,i,j,str,1))
						return true;
				}
			}
		}
					
		return false;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter m:");
		int m=sc.nextInt();
		System.out.println("Enter n:");
		int n=sc.nextInt();
		char words[][]=new char[m][n];
		System.out.println("Enter elements:");
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				words[i][j]=sc.next().charAt(0);
		System.out.println("Enter string:");
		String=sc.next();
		boolean ans=exists(words,m,n,str);
		System.out.println(ans);
	}
}