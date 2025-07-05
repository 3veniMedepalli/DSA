import java.util.*;
class RottenOrangesBFS
{
	public static int canRot(int mat[][],int m,int n)
	{
		int total=0,total1=0,ans=0;
        	Queue<Integer[]>q=new LinkedList<>();
        	for(int i=0;i<m;i++)
        	{
            		for(int j=0;j<n;j++)
            		{
                		if(mat[i][j]==2)
                    			q.offer(new Integer[]{i,j});
                		if(mat[i][j]!=0)
                    			total++;
            		}
        	}
        	if(total==0)
            		return 0;
        	int dx[]={0,0,1,-1};
        	int dy[]={1,-1,0,0};
        	while(!q.isEmpty())
        	{
            		int n1=q.size();
            		total1+=n1;
            		for(int i=0;i<n1;i++)
            		{
                		Integer p[]=q.poll();
                		for(int j=0;j<4;j++)
                		{
                   		int x=dx[j]+p[0];
                    		int y=dy[j]+p[1];
                    		if(x<0||x>=m||y<0||y>=n||mat[x][y]==0||mat[x][y]==2)
                        		continue;
                    		mat[x][y]=2;
                   		 q.offer(new Integer[]{x,y});
                }
            }
            if(q.size()!=0)
                ans++;
        }
        if(total==total1)
            return ans;
        return -1;
        
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter m:");
		int m=sc.nextInt();
		System.out.println("Enter n:");
		int n=sc.nextInt();
		int[][] grid=new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				grid[i][j]=sc.nextInt();
			}
		}
		int ans=canRot(grid,m,n);
		if(ans!=-1)
			System.out.println("The time required to rot all oranges is "+ans);
		else
			System.out.println("cannot rot all oranges");
	}
}
		
				