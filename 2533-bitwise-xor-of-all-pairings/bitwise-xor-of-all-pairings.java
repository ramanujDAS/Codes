class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int result = 0;
        if(n % 2 == 1){
            for(int val : nums2){
                result ^= val;
            }
        }

        if( m % 2 == 1){
            for(int val : nums1){
                result ^= val;
            }
        }
       return result;
     
    }
}