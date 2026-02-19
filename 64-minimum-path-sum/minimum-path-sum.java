class Solution {
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n + 1][m + 1];

        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                
                if(i == 1 && j == 1){
                    dp[i][j] = grid[i-1][j-1];
                    continue;
                }

                int up = dp[i - 1][j];
                int down = dp[i][j - 1];

                dp[i][j] = Math.min(up, down);

                dp[i][j] += grid[i - 1][j - 1];

            }
        }
        return dp[n][m];
    }
}