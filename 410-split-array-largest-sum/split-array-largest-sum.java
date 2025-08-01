class Solution {
    public int splitArray(int[] nums, int k) {

        int n = nums.length;
        int low = 0;
        int high = 0;
        int largestSum = Integer.MIN_VALUE;
        for (int num : nums) {
            low = Math.max(low,num);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countPartition(nums, mid);

            if (count > k) {
                low = mid + 1;
            }else{
              largestSum = Math.max(mid , largestSum);
              high = mid - 1;
            }

        }
      return low;
    }

    private int countPartition(int[] nums, int targetedSum) {

        int count = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > targetedSum) {
                sum = nums[i];
                count++;
            }
        }
        return count + 1;
    }
}