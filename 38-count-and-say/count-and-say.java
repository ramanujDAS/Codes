class Solution {
    public String countAndSay(int n) {
        String[] dp = new String[31];
        return calcRle(n, dp);
    }

    String calcRle(int n, String[] dp) {
        if (n == 1)
            return "1";

        if (dp[n] != null)
            return dp[n];

        String countSayString = calcRle(n - 1, dp);

        int i = 0;
        int countValue = 1;
        String foundString = "";
        while (i < countSayString.length() - 1) {
            if (countSayString.charAt(i) == countSayString.charAt(i + 1)) {
                countValue++;

            } else {
                foundString += "" + countValue + "" + countSayString.charAt(i);
                countValue = 1;

            }
            i++;
        }
        foundString += "" + countValue + "" + countSayString.charAt(i);
        dp[n] = foundString;
        return foundString;
    }
}