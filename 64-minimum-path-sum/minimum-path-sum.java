;
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int[] ar : dp)
            Arrays.fill(ar, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int left = Integer.MAX_VALUE;
                int top = Integer.MAX_VALUE;

                if (i > 0)
                    left = dp[i - 1][j];
                if (j > 0)
                    top = dp[i][j - 1];
                dp[i][j] = grid[i][j] + Math.min(left, top);
            }
        }
        return dp[n - 1][m - 1];
    }

    int getSum(int[][] grid, int i, int j, int[][] memo) {
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if (i == 0 && j == 0)
            return grid[i][j];

        if (memo[i][j] != -1)
            return memo[i][j];

        memo[i][j] = grid[i][j] + Math.min(getSum(grid, i - 1, j, memo), getSum(grid, i, j - 1, memo));
        return memo[i][j];

    }
}