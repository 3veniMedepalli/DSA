import java.util.*;
class StringMatchingKMP2
{
	static void computeLPS(String p,int m,int[] lps)
	{
		int len=0,i=1;
		lps[0]=0;
		while(i<m)
		{
			if(p.charAt(len)==p.charAt(i))
			{
				len++;
				lps[i]=len;
				i++;
			}
			else
			{
				if(len!=0)
					len=lps[len-1];
				else
				{
					lps[i]=len;
					i++;
				}
			}
		}
	}
	static void findKMP(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		int lps[]=new int[m];
		computeLPS(p,m,lps);
		int i=0,j=0;
		System.out.print("The pattern is found at ");
		while(i<n)
		{
			if(s.charAt(i)==p.charAt(j))
			{
				i++;
				j++;
			}
			if(j==m)
			{
				System.out.print((i-j)+" ");
				j=lps[j-1];
			}
			else if(i<n&&s.charAt(i)!=p.charAt(j))
			{
				if(j!=0)
					j=lps[j-1];
				else
					i++;
			}
		}
					
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Text:");
		String s=sc.next();
		System.out.println("Enter no of patterns:");
		int n=sc.nextInt();
		System.out.println("Enter patterns:");
		for(int i=0;i<n;i++)
		{
			findKMP(s,sc.next());
		}
	}
}