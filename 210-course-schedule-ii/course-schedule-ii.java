class Solution {
    public int[] findOrder(int V, int[][] edges) {
        int[] inDegree = new int[V];
         ArrayList<Integer> ar = new ArrayList<>();
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       Queue<Integer> q = new LinkedList<>();
       for(int i = 0;i<V ;i++){
         adj.add(new ArrayList<>());  
       }
   
       for(int [] edge : edges){
           int v = edge[0];
           int u = edge[1];
           adj.get(u).add(v);
       }
       
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) 
               inDegree[it]++;
        }
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) 
               q.add(i);
        }
        
          while(!q.isEmpty()){
            int node = q.poll();
            ar.add(node);
            for(int it : adj.get(node)){
                
               inDegree[it]--;
               
               if(inDegree[it] == 0){
                  q.add(it);
               }
            }
            
            
            
        }
      if(ar.size() ==V){
        int [] ans = new int[V];
      for(int i=0 ; i < ar.size();i++){
        ans[i] = ar.get(i);
      }
      return ans;
    }
      return new int[0];   
    }
}