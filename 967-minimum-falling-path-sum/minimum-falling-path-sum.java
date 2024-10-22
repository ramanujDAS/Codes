class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int minPath = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];

        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        // for(int i =0 ;i<m ;i++){
        // minPath = Math.min(minPath, getMinPath(matrix ,n-1 , i, dp));
        // }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if(i==0){
                 dp[i][j] = matrix[i][j];
                 continue;
               }
               int option1 = Integer.MAX_VALUE ,option2 = 0,option3 = Integer.MAX_VALUE;
               if(j > 0)option1 = dp[i-1][j-1];
                         option2 = dp[i-1][j];
               if(j+1 < m) option3 = dp[i-1][j+1];

               dp[i][j] = matrix[i][j] + Math.min(option1 , Math.min(option2, option3));
            }
        }

       for(int j = 0 ;j < m ;j++ ){
         minPath = Math.min(dp[n-1][j],minPath);
       } 

       return minPath;

    }

    int getMinPath(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || j < 0 || j >= grid[0].length)
            return Integer.MAX_VALUE;

        if (i == 0)
            return grid[0][j];

        if (dp[i][j] != -200)
            return dp[i][j];

        int option1 = getMinPath(grid, i - 1, j - 1, dp);
        int option2 = getMinPath(grid, i - 1, j, dp);
        int option3 = getMinPath(grid, i - 1, j + 1, dp);

        int minPathSum = grid[i][j] + Math.min(option1, Math.min(option2, option3));
        dp[i][j] = minPathSum;

        return minPathSum;

    }
}