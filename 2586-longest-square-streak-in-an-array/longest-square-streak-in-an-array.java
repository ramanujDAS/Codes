class Solution {
    public int longestSquareStreak(int[] nums) {
       HashSet<Integer> processed = new HashSet<Integer>();


        for( int num : nums)
        processed.add(num); 

       int longestStreak = 0;

       for( int i = 0; i< nums.length ; i++){
           
           int streak = 0;

           int currentNumber = nums[i];

           while(processed.contains(currentNumber)){
               streak++;
             
             if(((long)currentNumber *(long)currentNumber) > 1e5) break;

             currentNumber *= currentNumber;
           }

        longestStreak = Math.max(streak, longestStreak);   
       }

       return longestStreak < 2 ? -1 : longestStreak;
    }
}