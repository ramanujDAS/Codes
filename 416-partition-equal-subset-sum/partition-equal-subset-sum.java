class Solution {
 
    public boolean canPartition(int[] nums) {
     
      int sum = 0;
      for(int num : nums){
        sum +=num;
      }
     int n = nums.length;
      if(sum % 2 != 0) return false;
      int target = sum / 2 ;
     
      int dp[][] = new int[n][target + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);

     return getResult(nums, n -1 , target , dp);
       
   } 
  
     boolean getResult(int[] nums , int index , int target , int[][] dp){
        if(target == 0) return true;
        if(index < 0 || target < 0) return false;
    
        if(index == 0) return nums[index] == target ;

        if(dp[index][target] != -1) return dp[index][target] == 1 ? true : false; ;

        boolean pick = getResult(nums , index - 1, target - nums[index] , dp);

        boolean notPick = getResult(nums , index - 1, target , dp);
    
        dp[index][target] = pick || notPick ? 1  : 0;
        return pick||notPick;
     }

}