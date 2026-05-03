class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;

        long sum = 0;
        long funSum = 0;
        for(int i= 0 ; i< n ; i++){
            sum += nums[i];
            funSum += (long)nums[i] * i;
        } 

        long result = funSum;

        for(int k = 1; k < n ;k++){
      
           funSum =  funSum + sum - (n*nums[n-k]);

           result = result > funSum ? result : funSum;

        }
        return (int)result;
    }
}