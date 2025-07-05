import java.util.*;
class LongestCommonPrefixSort
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Trie tr=new Trie();
		System.out.println("Enter no of strings:");
		int n=sc.nextInt();
		System.out.println("Enter strings:");
		String s[]=new String[n];
		for(int i=0;i<n;i++)
		{	
			s[i]=sc.next();
		}
		Arrays.sort(s);
		String s1=s[0];
		String s2=s[s.length-1];
		int min=Math.min(s1.length(),s2.length());
		int i=0;
		for(i=0;i<min;i++)
		{
			if(s1.charAt(i)!=s2.charAt(i))
				break;
		}
		if(i==0)
			System.out.println("No common prefix");

		else
			System.out.println("The string "+s[0].substring(0,i)+" is longest common prefix");
	}
}
