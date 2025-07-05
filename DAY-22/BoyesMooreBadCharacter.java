import java.util.*;
class BoyesMooreBadCharacter
{
	static void badCharacter(String p,int m,int[] b)
	{
		for(int i=0;i<256;i++)
			b[i]=-1;
		for(int i=0;i<=m;i++)
			b[(int)p.charAt(i)]=i;
	}
	static void boyeMoore(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		int b[]=new int[256];
		badCharacter(p,m,b);
		int i=0;
		System.out.print("Found at ");
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
				if(i<n-m)
				{
					i=i+(m-b[(int)s.charAt(i+m)]);
				}
				else
					i=i+1;
			}
			else
			{
				i=i+(j-b[(int)s.charAt(i+j)]);
			}
		}
	}
			
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Text:");
		String s=sc.next();	,ki
		System.out.println("Enter pattern:");
		String p=sc.next();
		boyeMoore(s,p);
	}
}
