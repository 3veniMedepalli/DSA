import java.util.*;
class BoyesMooreCombine
{
	static void badCharacter(String p,int m,int[] b)
	{
		for(int i=0;i<256;i++)
			b[i]=-1;
		for(int i=0;i<=m;i++)
			b[(int)p.charAt(i)]=i;
	}

	static void strongSuffix1(int bpos[],int shift[],int m,String p)
	{
		int i=m,j=m+1;
		bpos[i]=j;
		while(i>0)
		{
			while(j<=m&&p.charAt(i-1)!=p.charAt(j-1))
			{
				if(shift[j]==0)
					shift[j]=j-i;
				j=bpos[j];
			}
			i--;
			j--;
			bpos[i]=j;	
		}
		
	}
	static void strongSuffix2(int bpos[],int shift[],int m,String p)
	{
		int j=bpos[0];
		for(int i=0;i<=m;i++)
		{
			if(shift[i]==0)
				shift[i]=j;
			if(i==j)
				j=bpos[j];
		}		
	}
	static void boyeMoore(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		int bpos[]=new int[m+1];
		int shift[]=new int[m+1];
		int b[]=new int[256];
		badCharacter(p,m,b);
		for(int i=0;i<=m;i++)
			shift[i]=0;
		strongSuffix1(bpos,shift,m,p);
		strongSuffix2(bpos,shift,m,p);
		int i=0;
		while(i<=(n-m))
		{
			int j=m-1;
			while(j>=0&&s.charAt(i+j)==p.charAt(j))
			{
				j--;
			}
			if(j<0)
			{
				System.out.print(i+" ");
				i=i+Math.max(shift[0],(m-b[(int)s.charAt(i+m)]));
			}
			else
			{
				i=i+Math.max(shift[j+1],(j-b[(int)s.charAt(i+j)]));
			}
		}

	}
			
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Text:");
		String s=sc.next();
		System.out.println("Enter pattern:");
		String p=sc.next();
		boyeMoore(s,p);
	}
}
