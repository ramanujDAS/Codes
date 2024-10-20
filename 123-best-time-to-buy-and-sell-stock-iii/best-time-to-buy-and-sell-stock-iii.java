class Solution {
    public int maxProfit(int[] prices) {
     int n = prices.length ;
     int transactionType = 2;
     int cap =2;
     int [][][] memo = new int[n][transactionType][cap+1];

     for( int [][] arr : memo){
        for(int [] ar : arr)
        Arrays.fill(ar, -1);
     }

      return getProfit(prices,0 , 0 , cap , memo);  
    }

    int getProfit(int[] prices , int index , int buy , int cap , int[][][] memo){

        if(index == prices.length) return 0 ;

        if(cap == 0) return 0;

        if(memo[index][buy][cap] != -1) {
            return memo[index][buy][cap];
        }

        int profit = 0;
        int op1 = 0;
        int op2 = 0;
        if(buy  == 0){
          op1 = 0 + getProfit(prices , index+1 , 0 , cap,memo);
          op2 = -prices[index] + getProfit(prices , index +1, 1 , cap,memo);
        }

        if(buy ==1){
            op1 = 0 + getProfit(prices , index+1 , 1 , cap , memo) ;
            op2 = prices[index] + getProfit(prices , index+1, 0 , cap -1 , memo);
        }
       profit = Math.max(op1,op2);

       memo[index][buy][cap] = profit;

       return profit;
    } 
}