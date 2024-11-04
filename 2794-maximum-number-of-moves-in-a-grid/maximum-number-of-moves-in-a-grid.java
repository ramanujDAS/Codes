class Solution {
    public int maxMoves(int[][] grid) {

       int n = grid.length;
       int m = grid[0].length;

       int [][] dp = new int[n][m];
       int maxMove = 0;
       for(int [] arr : dp)
         Arrays.fill(arr , -1);
        
        for( int i = 0 ;i< n ; i++){
            maxMove = Math.max(maxMove , move(grid ,i , 0 , -1 , dp) );
        }
       return maxMove;
    }

    private int move(int[][] grid, int i, int j, int prevNum, int[][] dp) {

        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length)
            return -1;

        int right, downRight, upRight;

        if (prevNum >= grid[i][j])
            return -1;

        if (dp[i][j] != -1)
            return dp[i][j];

        right = move(grid, i, j + 1, grid[i][j], dp);
        downRight = move(grid, i + 1, j + 1, grid[i][j], dp);
        upRight = move(grid, i - 1, j + 1, grid[i][j], dp);

        dp[i][j] = 1 + Math.max(right, Math.max(downRight, upRight));
        return dp[i][j];
    }
}