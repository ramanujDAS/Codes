class Solution {
    public int minCost(int n, int[] cuts) {

        int len = cuts.length;
        Arrays.sort(cuts);
        int[] cut = new int[len + 2];
        for (int i = 1; i < len + 2 - 1; i++) {
            cut[i] = cuts[i - 1];
        }
        cut[0] = 0;
        cut[len + 2 - 1] = n;
        int [][] memo = new int[len+2][len+2];
        for(int [] ar : memo){
            Arrays.fill(ar, -1);
        }
        return minFun(cut, 1, len,memo);

    }

    private int minFun(int[] cuts, int i, int j, int[][] memo) {

        if (i > j){
            return 0;
        }
        if(memo[i][j] != -1)
           return memo[i][j];

        int minAns = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int ans = cuts[j + 1] - cuts[i - 1]
                    + minFun(cuts, i, index - 1,memo)
                    + minFun(cuts, index + 1, j,memo);
           
            minAns = Math.min(minAns, ans);
        }
        memo[i][j] = minAns;
        return minAns;

    }
}