class Solution {
    public int longestOnes(int[] nums, int k) {

       int n = nums.length;
       int zeroes = 0;

       int ans = Integer.MIN_VALUE;

       int i = 0;
       int j = 0;
       while( j < n){

          if(nums[j] == 0){
            k--;
          }
          
          while(k < 0)
          { 
            if(nums[i] == 0)
               k++;
             i++;
          }

          ans = Math.max(ans , j - i +1);
        j++;  

       } 
     return ans;  
    }
}