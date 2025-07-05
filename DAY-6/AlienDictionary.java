 public String findOrder(String[] words) {
        // code here
        boolean[] p=new boolean[26];
        for(String s:words)
        {
            for(char ch:s.toCharArray())
                p[ch-'a']=true;
        }
        ArrayList<Integer>[]adj=new ArrayList[26];
        for(int i=0;i<26;i++)
            adj[i]=new ArrayList<>();
        int[] ind=new int[26];
        for(int j=0;j<words.length-1;j++)
        {
            String s1=words[j];
            String s2=words[j+1];
            int min=Math.min(s1.length(),s2.length());
            boolean found=false;
            for(int i=0;i<min;i++)
            {
                char c1=s1.charAt(i);
                char c2=s2.charAt(i);
                if(c1==c2)
                    continue;
                adj[c1-'a'].add(c2-'a');
                ind[c2-'a']++;
                found=true;
                break;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<26;i++)
        {
            if(ind[i]==0&&p[i])
            q.offer(i);
        }
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty())
		{
			int x=q.poll();
			sb.append(x+'a');	
			for(int a:adj[x])
			{
				ind[a]--;
				if(ind[a]==0)
					q.add(a);
			}
		}
		int v=0;
		for(int i=0;i<26;i++)
		{
		    if(p[i])
		        v++;
		}
		if(sb.length()!=v)
		        return "";
		 return sb.toString();

        
    }
    