class Solution {
    public int minInsertions(String s) {
       int n = s.length();
       StringBuilder res = new StringBuilder(s);
       String revS = res.reverse().toString();
       int m = revS.length();
       int [][] dp = new int[n+1][m+1];
       for(int i =1 ;i <=n ;i++){
         for(int j =1 ;j<=m;j++){
            if(s.charAt(i-1) == revS.charAt(j-1))
                dp[i][j] = 1 + dp[i-1][j-1];
             else{
                dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
             }   
         }
       } 
       return n-dp[n][m];  
    }
}