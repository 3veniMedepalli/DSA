import java.util.*;
class SplitStringMaxUnique
{
	static int find(String s)
	{
		HashMap<Character,Integer>l=new HashMap<>();
		HashMap<Character,Integer>r=new HashMap<>();
		for(char c:s.toCharArray())
			r.put(c,r.getOrDefault(c,0)+1);
		int max=-1;
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			l.put(ch,l.getOrDefault(ch,0)+1);
			r.put(ch,r.getOrDefault(ch,0)-1);
			int t=0;
			for(Character c:l.keySet())
			{
				if(r.get(c)>0)
					t++;
			}
			max=Math.max(max,t);
		}
		return max;
	}	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String s=sc.next();
		System.out.println("The ans is "+find(s));
	}
}