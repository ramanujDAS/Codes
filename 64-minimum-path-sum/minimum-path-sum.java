class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];

        for(int []ar : memo)
        Arrays.fill(ar,-1);

      return getSum(grid,grid.length-1, grid[0].length-1 , memo) ;
    }

    int getSum(int[][] grid , int i , int j,int[][] memo ){
       if(i< 0 || j < 0) return Integer.MAX_VALUE ;
        
        if(i==0 && j==0 )return grid[i][j];

        if(memo[i][j] != -1) return memo[i][j];
      
       memo[i][j]= grid[i][j] +  Math.min(getSum(grid,i-1,j,memo),getSum(grid,i,j-1,memo));
       return memo[i][j]; 

    }
}