class Solution {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return minDistance(word1, word2, 0, 0, dp);
    }

    private int minDistance(String word1, String word2, int i, int j, int[][] dp) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (dp[i][j] != -1)
            return dp[i][j];

        int minDis = 01;
        if (word1.charAt(i) == word2.charAt(j)) {
            minDis = minDistance(word1, word2, i + 1, j + 1,dp);
        } else {

            minDis = 1 + Math.min(minDistance(word1, word2, i + 1, j + 1,dp),
                    Math.min(minDistance(word1, word2, i + 1, j,dp), minDistance(word1, word2, i, j + 1,dp)));
        }
        dp[i][j] = minDis;
        return minDis;

    }

}