class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ;
        int m = isConnected[0].length ;
       int [] visited = new int[n] ;
       int ans = 0;
     for(int i=0 ;i < n ;i++){
        if(visited[i] == 0){
                ans++;
                fun(isConnected , i ,0,visited);
            
        }
     }
   return ans;
    }

    void fun(int[][] graph , int i, int j , int [] visited){
     if(visited[i]==1) return;
         visited[i]=1;
        for(int k =0 ;k< graph.length ; k++){
                 if(graph[i][k] == 1 && visited[k] == 0)
                      fun(graph,k,0,visited);
        }
       

    }
}