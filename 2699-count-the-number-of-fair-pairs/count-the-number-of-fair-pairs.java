class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
     Arrays.sort(nums);

     return findSumCount(nums , upper + 1) - findSumCount(nums , lower); 
    }

    long findSumCount( int[] nums , int sum){
        long count = 0;
     
         int low = 0;
         int high = nums.length -1 ;

         while( low < high){
            int tempSum = nums[low] + nums[high];

            if(tempSum < sum){
                count += (high - low);
                low ++;
            }else{
                high--;
            }

         }

         return count;
    }
}