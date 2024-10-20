class Solution {
    public int maxProfit(int[] prices) {

    int n = prices.length;
    int transactionOption = 2;
    int [][] memo = new int[n][transactionOption];

    for(int i = 0 ;i<n;i++){
        Arrays.fill(memo[i],-1);
    }

        return getProfit(prices, 0, 0,memo);
    }

    int getProfit(int[] prices, int index, int buy , int[][] memo) {
    if(index == prices.length) return 0;

    if(memo[index][buy] != -1) return memo[index][buy];

        int profit = 0;
        int op1 = 0;
        int op2 = 0;
        if (buy == 0) {
            op1 = 0 + getProfit(prices, index + 1, 0,memo); // do nothing
            op2 = -prices[index] + getProfit(prices, index + 1, 1,memo); // buy

        }
        if (buy == 1) {
            op1 = 0 + getProfit(prices, index + 1, 1,memo); // do nothing
            op2 = prices[index] + getProfit(prices, index + 1, 0,memo); // sell
        }
        profit = Math.max(op1, op2);
        memo[index][buy] = profit;
        return profit;
    }
}