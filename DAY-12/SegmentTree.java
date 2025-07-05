import java.util.*;
class SegmentTree
{
	static void build(int tree[],int n,int a[])
	{
		for(int i=0;i<n;i++)
			tree[i+n]=a[i];
		for(int i=n-1;i>0;i--)
			tree[i]=Math.min(tree[2*i],tree[2*i+1]);
	}
	static int query(int tree[],int n,int l,int r)
	{
		int res=Integer.MAX_VALUE;
		l=l+n;
		r=r+n+1;
		while(l<r)
		{
			if((l&1)==1)
			{
				res=Math.min(res,tree[l]);
				l++;
			}
			if((r&1)==1)
			{
				r--;
				res=Math.min(res,tree[r]);
			}
			l=l/2;
			r=r/2;
		}
		return res;
	}
	static void update(int tree[],int a[],int n,int pos,int val)
	{
		a[pos]=val;
		pos=pos+n;
		tree[pos]=val;
		while(pos>1)
		{
			pos=pos>>1;
			tree[pos]=Math.min(tree[2*pos],tree[2*pos+1]);
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=sc.nextInt();
		System.out.println("Enter elements:");
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int tree[]=new int[2*n];
		build(tree,n,a);
		System.out.println("Enter no of queries:");
		int m=sc.nextInt();
		while(m>0)
		{
			System.out.println("Enter query:");
			int l=sc.nextInt();
			int r=sc.nextInt();
			int ans=query(tree,n,l,r);
			System.out.println("The minimum is "+ans);
			m--;
		}
		System.out.println("Enter position to update:");
		int pos=sc.nextInt();
		System.out.println("Enter value:");
		int val=sc.nextInt();
		update(tree,a,n,pos,val);
		System.out.println(query(tree,n,1,4));
	}
}
		
			
			
		
