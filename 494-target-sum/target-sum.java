class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for(int num : nums){
            total += num;
        }
        int n = nums.length;
        int [][] dp = new int[n][2*total +1];

        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
       return findTarget(nums , 0 , 0,target, dp , total); 
    }

    int findTarget(int []nums , int target , int index, int sum , int[][]dp , int total){

      if(index == nums.length){
            if(target == sum) return 1;
            
           return 0;
        }

      if(dp[index][total + target] != -1) return dp[index][total+target];

        int option1 =  findTarget(nums, target - nums[index] , index +1 , sum ,dp , total);
        int option2 =  findTarget(nums , target + nums[index], index +1 ,sum , dp , total);

      dp[index][total + target] = option1 + option2;
       return option1 + option2;
    }
}