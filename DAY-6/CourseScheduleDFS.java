import java.util.*;
class ConnectCitiesDFS {
    public static boolean dfs(ArrayList<ArrayList<Integer>>adj,int s,boolean visited[],Stack<Integer>st,boolean[] recStack){
        if(recStack[s]==true) return true;
        if(visited[s]==true) return false;
        visited[s]=true;
        recStack[s]=true;
        for(int x1:adj.get(s))
	{
            if(dfs(adj,x1,visited,st,recStack))
                return true;
        }
        
        recStack[s]=false;
        st.push(s);
        return false;
    }
    public static int[] topoSort(int v,ArrayList<ArrayList<Integer>>adj){
        boolean visited[]=new boolean[v];
        boolean recStack[]=new boolean[v];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,st,recStack)) return new int[]{};
            }	
        }
        int ans[]=new int[v];
        int k=0;
        while(!st.isEmpty()){
            ans[k++]=st.pop();
        }
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
      
        int[][] edges = new int[m][2];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        for(int[] i:edges){
            if (i[0] >= n || i[1] >= n) continue;
            adj.get(i[0]).add(i[1]);
        }
        int[] res=topoSort(n,adj);
        if(res.length==0){
            System.out.print("cycle detected.cannot complete all courses");
        }
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}