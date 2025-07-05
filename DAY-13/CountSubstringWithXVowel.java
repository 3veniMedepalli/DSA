import java.util.*;
class CountSubstringWithXVowel
{
	static boolean isVowel(char c)
	{
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			return true;
		return false;
	}	
	static int count(String s,int k,int x)
	{
		int ans=0;
		int v=0;
		int n=s.length();
		for(int i=0;i<k;i++)
		{
			if(isVowel(s.charAt(i)))
				v++;
		}
		if(v==x)
			ans++;
		for(int i=k;i<n;i++)
		{
			if(isVowel(s.charAt(i-k)))
				v--;
			if(isVowel(s.charAt(i)))
				v++;
			if(v==x)
				ans++;
		}
		return ans;
		
	}
								
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String s=sc.next();
		System.out.println("Enter k:");
		int k=sc.nextInt();
		System.out.println("Enter x:");
		int x=sc.nextInt();
		int ans=count(s,k,x);
		System.out.println("The count is "+ans);
	}
}