class Solution {
    int mod=1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
    
      int n = arr.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        int[] sums = new int[n+1];
        for(int i = 0; i < n ; ++i)
           right[i+1] = arr[i];
           
        int res = 0;
        for (int i = 1; i < n+1; i++) {
            int cur = right[i];
            int j = i - 1;
            while (right[j] >= cur) 
                j = left[j];
            
            left[i] = j;
            sums[i] = sums[j] + cur * (i - j);
            res = (res + sums[i]) % mod;
        }
        return res; 

    }
}