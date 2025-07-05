import java.util.*;
class StringMatchingSlideWindow
{
	static void findMatch(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		int k=1;
		int j=0;
		for(int i=0;i<=(n-m);i++)
		{
			if(s.charAt(i)==p.charAt(0))
			{
				for(j=i+1;j<(i+m);j++)
				{
					if(s.charAt(j)!=p.charAt(k))
						break;
					k++;
				}
				k=1;
				if(j==i+m)
					System.out.print(i+" ");
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
		System.out.print("The pattern is found at ");
		findMatch(s,p);
	}
}