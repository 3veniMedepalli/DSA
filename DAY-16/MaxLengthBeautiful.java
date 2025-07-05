import java.util.*;
class MaxLengthBeautiful
{
	static int maxLength(String s)
	{
		int n=s.length();
		int j=0,k=-1;
		int max=-1;
		char v[]={'a','e','i','o','u'};
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			if(k==-1&&ch=='a')
			{
				j=i;
				k=0;
			}
			else if(k>=0)
			{
				if(ch==v[k])
					continue;
				else if(k<4&&ch==v[k+1])
					k++;
				else if(ch=='a')
				{
					j=i;
					k=0;
				}
				else 
					k=-1;
				if(k==4)
					max=Math.max(max,(i-j+1));
			}
		}
		return max;	
	}
				
				
		
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String s=sc.next();
		int ans=maxLength(s);
		System.out.println("The length of longest Beautiful substring is "+ans);
	}
}