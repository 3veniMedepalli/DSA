import java.util.*;
class CatalanNumberMem
{
	static int find(int n)
	{
	
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		int res=0;
		for(int i=0;i<n;i++)
			res+=find(i)*find(n-i-1);
		return res;
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number :");
		int n=sc.nextInt();
		System.out.print(find(n));
	}
}
