import java.util.*;
class MinLengthWithAllCharInString
{
	static int mixLength(String s)
	{
		HashSet<Character>h=new HashSet<>();
		for(char x:s.toCharArray())
			h.add(x);
		int min=Integer.MAX_VALUE;
		HashMap<Character,Integer>hm=new HashMap<>();
		int n=s.length();
		int j=0,k=0;
		for(int i=0;i<n;i++)
		{
			char c=s.charAt(i);
			hm.put(c,hm.getOrDefault(c,0)+1);
			while(hm.size()==h.size())
			{
				min=Math.min(min,i-j+1);
				char l=s.charAt(j);
				hm.put(l,hm.getOrDefault(l,0)-1);
				if(hm.get(l)==0)
					hm.remove(l);
				j++;
			}		
		}
		return min;
				
	}
				
				
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String s=sc.next();
		int ans=mixLength(s);
		System.out.println("The length of minimum substring contains all characters is "+ans);
	}
}