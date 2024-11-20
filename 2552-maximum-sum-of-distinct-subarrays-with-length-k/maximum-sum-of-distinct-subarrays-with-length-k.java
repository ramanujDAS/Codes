class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> mapIndex = new HashMap<>();
        long ans = 0;
        int end = 0;
        int begin = 0;
        long currentSum = 0;

        while (end < nums.length) {

            int currentNum = nums[end];
            int lastIndex = mapIndex.getOrDefault(currentNum, -1);

            while (begin <= lastIndex || (end - begin + 1) > k) {
                currentSum -= nums[begin];
                begin++;
            }

            mapIndex.put(currentNum, end);
            currentSum += currentNum;

            if (end - begin + 1 == k) {
                ans = Math.max(ans, currentSum);
            }

            end++;

        }

        return ans;
    }
}