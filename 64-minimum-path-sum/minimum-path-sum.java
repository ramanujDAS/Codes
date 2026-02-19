class Solution {
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = 0;
                int down = 0; 
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if(i == 0){
                   dp[i][j] = dp[i][j-1];
                   dp[i][j] += grid[i][j];
                   continue;
                }
                if(j == 0){
                    dp[i][j] = dp[i-1][j];
                    dp[i][j] +=grid[i][j];
                    continue;
                }

            
                    up = dp[i - 1][j];
               
                    down = dp[i][j - 1];

                dp[i][j] = Math.min(up ,  down);

                dp[i][j] += grid[i][j];

            }
        }
      return dp[n-1][m-1];
    }
}