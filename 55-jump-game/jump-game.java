class Solution {
    public boolean canJump(int[] nums) {
       int n = nums.length;

       int maxCoverage = 0 ;

       for(int i = 0 ;i < n ;i++){

        if(i > maxCoverage) return false;


        maxCoverage  = Math.max(maxCoverage , nums[i] + i);
       }
       return true;

    }
}