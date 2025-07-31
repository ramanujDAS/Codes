class Solution {
    public int smallestDivisor(int[] piles, int h) {
           int low = 1;
        int high = findMax(piles);
        int minRate = Integer.MAX_VALUE;
        while (low <= high) {
            int mid =  low + (high - low)/2; 
            int hour = totalHoursToEat(mid , piles);

            if (hour <= h) {
                minRate = Math.min(minRate, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minRate;
    }

    private int findMax(int[] piles) {
        int maxValue = Integer.MIN_VALUE;

        for (int ch : piles) {
            if (maxValue < ch) {
                maxValue = ch;
            }
        }
        return maxValue;

    }

    private int totalHoursToEat(int rate , int[] piles){
         int requiredHours = 0;

         for( int pile : piles){
           requiredHours += Math.ceil((double)(pile) / (double)(rate));  
            }
         return requiredHours;     
         }



    
}