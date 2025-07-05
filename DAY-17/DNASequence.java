import java.util.*;
class DNASequence
{
	static ArrayList<String> findSeq(String s)
	{
		HashMap<String,Integer>hm=new HashMap<>();
		int n=s.length();
		for(int i=0;i<=(n-10);i++)
		{
			String str=s.substring(i,i+10);
			hm.put(str,hm.getOrDefault(str,0)+1);
		}
		ArrayList<String> ans=new ArrayList<>();
		for(String x:hm.keySet())
		{
			if(hm.get(x)>=2)
				ans.add(x);
		}
		return ans;
	}
			
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String:");
		String s=sc.next();
		ArrayList<String>ans=findSeq(s);
		for(String x:ans)
			System.out.print(x+" ");
	}
}