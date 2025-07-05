import java.util.*;
class CountDistnictSubstring2
{

	static int countDistnictSubstring(String s)
	{
		int n=s.length();A
		HashSet<Character>h=new HashSet<>();
		int count=0;
		int i=0,j=0;
		while(j<n-1)
		{
			if(!h.contains(s.charAt(j)))
			{
				h.add(s.charAt(j));
				count+=(j-i+1);
				j++;
			}
			else
			{
				h.remove(s.charAt(i));
				count=count+1;
				j++;
				i=j;
			}
		}
		return count;
		
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
