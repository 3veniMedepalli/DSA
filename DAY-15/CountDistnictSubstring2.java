import java.util.*;
class CountDistnictSubstring2
{

	static int countDistnictSubstring(String s)
	{
		int n=s.length();
		HashSet<Character>h=new HashSet<>();
		int count=0;
		int i=0,j=0;
		HashSet<String>hs=new HashSet<>();
		while(j<n)
		{
			if(!h.contains(s.charAt(j)))
			{
				StringBuilder sb=new StringBuilder();
				sb.append(s.substring(i,j+1));
				if(!hs.contains(sb.toString()))
					hs.add(sb.toString());
				h.add(s.charAt(j));
				j++;
			}
			else 
			{		
				h.remove(s.charAt(i));
				i++;
			}
		}
		return hs.size();
		
	}	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String s=sc.next();
		int ans=countDistnictSubstring(s);
		System.out.println("The count of subarray with distnict elements is "+ans);
	}
}
