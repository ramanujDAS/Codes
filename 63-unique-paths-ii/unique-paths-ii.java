class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
     int [][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(i >=0 && j >= 0 && grid[i][j]==1){
                 dp[i][j]=0;
                 continue;
               }
               if(i ==0 && j ==0){
                dp[i][j] = 1;
                continue;
               }
          int up = 0;
          int left = 0;

          if(i> 0)up = dp[i-1][j];
          if(j>0) left = dp[i][j-1];

               dp[i][j] = up + left; 

            }
        }

        return dp[n-1][m-1];
    }

    int getPath(int[][] grid, int i, int j) {

        if (i < 0 || j < 0)
            return 0;

        if (i >= 0 && j >= 0 && grid[i][j] == 1)
            return 0;

        if (i == 0 && j == 0)
            return 1;

        int up = getPath(grid, i - 1, j);
        int left = getPath(grid, i, j - 1);

        return up + left;

    }
}