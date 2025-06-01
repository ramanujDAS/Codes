class Solution {
    public int maxProduct(int[] nums) {

       int minProduct = nums[0];
       int maxProduct = nums[0];
       int n = nums.length;
       int result = nums[0];
       for( int i = 1; i < n ;i++){
       int temp  = Math.min(nums[i] , Math.min(minProduct * nums[i] , maxProduct * nums[i]));
         maxProduct = Math.max(nums[i] , Math.max(minProduct * nums[i] , maxProduct * nums[i]));
         minProduct = temp;
         result = Math.max(result , maxProduct);

       }
      return result;
    }
}