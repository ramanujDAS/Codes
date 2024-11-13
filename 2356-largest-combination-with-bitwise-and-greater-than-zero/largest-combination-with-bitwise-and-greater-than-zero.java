class Solution {
    public int largestCombination(int[] candidates) {

       int [] bitCount = new int[24];
        
        for( int i = 0;i<candidates.length ; i++){

            for(int j = 0; j<24 ;j++){
                bitCount[j] += (candidates[i] & (1<<j) ) > 0 ? 1 : 0 ;
            }
        }
      
      int maxComb  = 0 ;

      for( int i = 0 ;i<24 ; i++){
        maxComb = Math.max(maxComb , bitCount[i]);
      }
      
      return maxComb;
       
    }
}