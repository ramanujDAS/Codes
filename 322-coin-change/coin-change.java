class Solution {
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        if (amount == 0)
            return 0;

      int [][] dp = new int[n][amount+1];

      for( int[] ar : dp)
      Arrays.fill(ar , -1);

        int coin = getCoins(coins, n - 1, amount , dp);
        return coin >= Math.pow(10, 9) ? -1 : coin;

    }

    int getCoins(int[] coins, int index, int amount , int [][] dp) {
        if (amount == 0)
            return 0;

        if (amount < 0 || index < 0)
            return (int) Math.pow(10, 9);

        if (index == 0) {
            if (amount % coins[index] == 0)
                return amount / coins[index];
            else
                return (int) Math.pow(10, 9);
        }
   if(dp[index][amount] != -1) return dp[index][amount];
  
        int notPick = 0 + getCoins(coins, index - 1, amount , dp);

        int pick = 1 + getCoins(coins, index, amount - coins[index] , dp);
       
        dp[index][amount] = Math.min(pick , notPick);
        return Math.min(pick, notPick);

    }

}