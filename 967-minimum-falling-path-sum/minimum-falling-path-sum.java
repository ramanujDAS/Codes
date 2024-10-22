class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int minPath = Integer.MAX_VALUE;
        int [][] dp = new int[n][m];

        for(int[] arr : dp){
            Arrays.fill(arr, -200);
        }
        for(int i =0 ;i<m ;i++){
            minPath = Math.min(minPath, getMinPath(matrix ,n-1 , i, dp));
        }
      return minPath; 
    }

    int getMinPath(int[][] grid , int i , int j, int[][] dp){
        if(i < 0 || j< 0 || j >= grid[0].length) return Integer.MAX_VALUE;

        if(i ==0) return grid[0][j]; 
       
        if(dp[i][j] != -200) return dp[i][j];


        int option1 = getMinPath(grid,i-1,j-1,dp);
        int option2 = getMinPath(grid,i-1,j,dp);
        int option3 = getMinPath(grid,i-1,j+1,dp);

        int minPathSum = grid[i][j] + Math.min(option1,Math.min(option2,option3));
         dp[i][j] = minPathSum;

     return minPathSum;

    }
}