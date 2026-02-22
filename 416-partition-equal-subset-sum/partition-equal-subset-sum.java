class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 == 1)
            return false;

        int target = totalSum / 2;

        int index = nums.length;

        boolean[][] dp = new boolean[index + 1][target + 1];

        dp[0][0] = true;

        for (int i = 1; i <= index; i++) {
            for (int j = 0; j <= target; j++) {

                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }

                boolean notIncluded = dp[i - 1][j];

                boolean included = false;
                if (j - nums[i - 1] >= 0)
                    included = dp[i - 1][j - nums[i - 1]];

                dp[i][j] = included || notIncluded;
            }

           
        }
         return dp[index][target];
    }
}