class Solution {
    public int[] singleNumber(int[] nums) {

        int valXor = 0;

        for (int val : nums) {
            valXor = valXor ^ val;
        }

        int rightMSetBitNum = valXor & (-valXor);

        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {

            if ((nums[i] & rightMSetBitNum) == 0) {
                ans[0] = ans[0] ^ nums[i];
            }

            else {
                ans[1] = ans[1] ^ nums[i];
            }

        }
        return ans;
    }
}