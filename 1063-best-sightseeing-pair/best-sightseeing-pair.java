class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int n = values.length;


        int prevMax = values[0] + 0;
        int maxScore = 0;
        for( int i = 1 ;i < n; i++){
            
            maxScore = Math.max(maxScore , values[i] - i + prevMax);

            if(prevMax < (values[i] + i))
                 prevMax = values[i] + i;   
           
        }
        return maxScore;
    }
}