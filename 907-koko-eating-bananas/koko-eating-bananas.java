class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       
       int low = 0;
       int high = findMax(piles) ;
        
       int ans = Integer.MAX_VALUE;
       while(low <= high){

        int mid = low + ( high - low)/2 ;
        int totalHours = getHours(piles , mid);

        if(totalHours <=h){
            ans = Math.min(ans , mid);
            high = mid -1;
        }else{
            low = mid + 1;
        }

       }
     return ans;

    }

    int findMax(int []piles){
        int n = piles.length ;

        int maxElement = Integer.MIN_VALUE;

        for( int i =0 ;i< n ;i++)
        {
            maxElement = Math.max(maxElement , piles[i]);
        }
        return maxElement;
    }

    int getHours(int [] piles , int bananaPerHour){
        int hours = 0;

        for( int i =0 ;i<piles.length ;i++){
            hours += Math.ceil((double)piles[i]/(double)bananaPerHour);
        }
        return hours;
    }


    
 
}