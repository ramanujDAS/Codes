class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans += dfs(matrix, i, j, dp);
            }
        }
        return ans;

    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {

        if (i < 0 || i == matrix.length || j < 0 || j == matrix[0].length)
            return 0;

        if (matrix[i][j] == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        int left = dfs(matrix, i - 1, j , dp);
        int top = dfs(matrix, i, j - 1 , dp);
        int corner = dfs(matrix, i - 1, j - 1 , dp);

        int sqares = Math.min(left, Math.min(top, corner)) + 1;
        dp[i][j] = sqares;
        return sqares;

    }
}