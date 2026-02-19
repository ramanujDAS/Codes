class Solution {
    public int minimumTotal(List<List<Integer>> t) {

        int n = t.size();
        int m = t.get(n - 1).size();

        int[][] dp = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
               
               if(i == n-1){
                  dp[i][j] = t.get(i).get(j);
                  continue;
               }

               dp[i][j] = Math.min(dp[i+1][j] , dp[i+1][j+1]) + t.get(i).get(j);

            }
        }

        return dp[0][0];
    }
}