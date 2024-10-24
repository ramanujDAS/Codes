class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp = new int[coins.length][amount +1];
        for( int [] arr : dp){
            Arrays.fill(arr , -1);
        }
        return getCombination(coins , amount , coins.length -1 , dp);
    }

    int  getCombination(int [] coins , int amount ,int index , int [][] dp){

       if(amount == 0) return 1;

       if(index <0 || amount < 0) return 0;
     
        if(dp[index][amount] != -1) return dp[index][amount];
    
       int pick = getCombination(coins , amount - coins[index] , index, dp);

       int notPick = getCombination(coins,amount , index -1 , dp);
       dp[index][amount] = pick + notPick;
       return pick  + notPick;

       
    
    }
}