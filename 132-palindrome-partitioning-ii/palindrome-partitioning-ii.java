class Solution {
    public int minCut(String s) {
        int n = s.length();
        int [] dp = new int[n];
        Arrays.fill(dp , -1);
        return fun(0, s,dp);
    }

    private int fun(int start, String s , int [] dp) {
        if (start >= s.length() || isPalindrome(s, start, s.length() - 1)) {
            return 0;
        }

        if(dp[start] != -1)
         return dp[start];
        int minCut = Integer.MAX_VALUE;
        for (int index = start; index < s.length(); index++) {

            if (isPalindrome(s, start, index)) {
                int cuts = 1 + fun(index + 1, s,dp);
                minCut = Math.min(cuts, minCut);

            }
        }
        dp[start] = minCut;
        return minCut;

    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}