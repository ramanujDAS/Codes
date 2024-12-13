class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        
        int [] arr = new int[nums.length] ;
        arr[0] = 1;
        for( int i  = 1 ; i < nums.length ; i++){
            if((nums[i] + nums[i-1]) % 2 == 0){
                arr[i] = 1;
            }
            else{
                arr[i] = arr[i-1] + 1;
            }
        }

        boolean [] ans = new boolean[queries.length];

        for( int i = 0; i< queries.length ; i++){
            ans[i] = (arr[queries[i][1]] - arr[queries[i][0]]) == ( queries[i][1] - queries[i][0]);
        }

        return ans;
    }
}