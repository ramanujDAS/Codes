class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int [][] dp = new int[text1.length()+1][text2.length()+1] ;
         
        for(int [] row : dp){
            Arrays.fill(row , 0);
        } 

        //dp

       // dp[0][0] = 1;

        for(int i =1;i<=text1.length() ;i++){
            for( int j=1 ;j<=text2.length() ;j++){

                 if(text1.charAt(i-1) == text2.charAt(j-1))
                     dp[i][j] = 1 + dp[i-1][j-1] ;  
                  else
                     dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
             
            }
        } 
        return dp[text1.length()][text2.length()];
       // return longestCommonSubsequence(text1, text2,0,0,dp);
    }

   private int longestCommonSubsequence(String text1 , String text2 , int i , int j, int [][] dp){
    if(i == text1.length() || j == text2.length()) return 0;

    if(dp[i+1][j+1] != -1){
        return dp[i+1][j+1] ;
    }
     int value = 0;
    if(text1.charAt(i) == text2.charAt(j)){
       value = 1+longestCommonSubsequence(text1, text2,i+1,j+1,dp);
    }
    else{
       value = Math.max(longestCommonSubsequence(text1, text2,i,j+1,dp),longestCommonSubsequence(text1, text2,i+1,j,dp));
         
    }
    dp[i+1][j+1] = Math.max(dp[i+1][j+1] , value);
    return value;
   } 
}