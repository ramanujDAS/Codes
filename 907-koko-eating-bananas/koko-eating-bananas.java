class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = findMax(piles);
        int minRate = Integer.MAX_VALUE;
        while (low <= high) {
            int mid =  low + (high - low)/2; 
             int hour = 0;
             for( int pile : piles){
                hour += Math.ceil((double)(pile) / (double)(mid));  
            }

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

   



}
