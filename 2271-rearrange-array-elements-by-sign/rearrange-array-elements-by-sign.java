class Solution {
    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int pos = 0, neg = 1;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            }

            if (nums[i] < 0) {
                ans[neg] = nums[i];
                neg += 2;
            }

        }
        return ans;

        // while(pos < n && neg<n){

        // if(nums[pos] > 0)pos += 2;

        // else if(nums[neg]< 0) neg+=2;

        // else{
        // int value = nums[pos] ;
        // nums[pos] = nums[neg];
        // nums[neg] = value;
        // }
        // }

        // return nums;
    }
}