import java.util.*;
class StringMatchingSlideWindow2
{
	static void findMatch(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		int j=0;
		for(int i=0;i<=(n-m);i++)
		{
			for(j=0;j<m;j++)
			{
				if(s.charAt(i+j)!=p.charAt(j))
						break;
			}
			if(j==m)
				System.out.print(i+" ");
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Text:");
		String s=sc.next();
		System.out.println("Enter pattern:");
		String p=sc.next();
		System.out.print("The pattern is found at ");
		findMatch(s,p);
	}
}