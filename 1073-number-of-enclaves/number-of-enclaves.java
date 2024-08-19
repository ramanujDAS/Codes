class Solution {
    public int numEnclaves(int[][] grid) {

   int[][] visited = new int[grid.length][grid[0].length];
        for(int i =0 ; i<grid.length ;i++){
            for(int j =0 ;j<grid[0].length ;j++){
                if(i==0 || j ==0 || i ==grid.length-1 || j == grid[0].length -1)
                  dfs(grid,visited,i,j);
            }
        }

     int ans =0 ;   

     for(int i =0;i<grid.length ;i++){
        for(int j =0;j<grid[0].length ;j++){
            if(visited[i][j]==0 && grid[i][j]==1)ans++;
        }
     }
        return ans;
    }
   void dfs(int[][] grid ,int [][] visited , int i, int j){
    if(i< 0 || j<0 || i==grid.length || j == grid[0].length || visited[i][j]==1 || grid[i][j] ==0)return ;

     visited[i][j] = 1;

     dfs(grid, visited , i,j+1) ;
      dfs(grid, visited , i,j-1) ;
       dfs(grid, visited , i+1,j) ;
        dfs(grid, visited , i-1,j) ;


   }

}