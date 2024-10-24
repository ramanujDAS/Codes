class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        if (amount == 0)
            return 0;

      int [][] dp = new int[n][amount+1];

      for( int[] ar : dp)
      Arrays.fill(ar , -1);

         //int coin = getCoins(coins, n - 1, amount , dp);
        // return coin >= Math.pow(10, 9) ? -1 : coin;
     
     for( int j =0 ;j<=amount ;j++){
        if( j % coins[0] == 0){
            dp[0][j] = j / coins[0];
        }
        else{
            dp[0][j] =(int) Math.pow(10,9);
        }
     }
       
       for( int i = 1; i < n ;i++){
        for(int j = 0 ;j <=amount ;j++){

            int notPick = dp[i-1][j] ;
            int pick = (int)Math.pow(10,9);
            if(coins[i] <= j){
              pick = dp[i][ j - coins[i]] + 1;
            }
           dp[i][j] = Math.min(pick , notPick); 
        }
       }
      
      if(dp[n-1][amount] >= (int)Math.pow(10,9)) return -1;

      return dp[n-1][amount];

    }

    int getCoins(int[] coins, int index, int amount , int [][] dp) {
        if(amount == 0) return 1;

       if(index <0 || amount < 0) return 0;
     
    
        // if (index == 0) {
        //     if (amount % coins[index] == 0)
        //         return amount / coins[index];
        //     else
        //         return (int) Math.pow(10, 9);
        // }
   if(dp[index][amount] != -1) return dp[index][amount];
        int pick = 1 + getCoins(coins, index, amount - coins[index] , dp);
        int notPick = 0 + getCoins(coins, index - 1, amount , dp);

  
       
        dp[index][amount] = Math.min(pick , notPick);
        return Math.min(pick, notPick);

    }

}