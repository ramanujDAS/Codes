class Solution {
    public int minSteps(int n) {
      int [] dp = new int[n+1] ;
      Arrays.fill(dp, Integer.MAX_VALUE) ;
      dp[0] = 0;
      dp[1] = 0;
      for(int i = 1 ;i < n+1 ; i++){
           for( int j = 1 ;j<i;j++){
              if(i % j == 0){
                dp[i] = Math.min(dp[i],dp[j] + i/j) ;
              }
           }
        } 
      return dp[n];   
    }
}