class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
         
         for(int i = 0 ;i < n ;i++){
            if(nums[i] > nums[(i+1) % n]){
                count++;
            }
         }

        return count <= 1; // if 0 then already sorted / if count ==1 then rotated if count==2 //-> the. not sorted  

    }
}