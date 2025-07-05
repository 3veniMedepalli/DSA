import java.util.*;
class GreatestPrimeFunction
{
	static boolean isPrime(int n)
	{
		if(n==0||n==1)
			return false;
		for(int i=2;i*i<=n;i++) 
		{
			if(n%i==0)
				return false;		
		}
		return true;
	}

	static int find(int x)
	{
		for(int i=x;i>=0;i--)
		{
			if(isPrime(i))
				return i;
		}
		return 0;
	}
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter x:");
		int x=sc.nextInt();
		System.out.println("Enter y:");
		int y=sc.nextInt();
		System.out.println("The answer is "+(find(x)-find(y)));
	}
}