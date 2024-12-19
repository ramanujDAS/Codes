class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int n = arr.length;

        int [] prefixSum = new int[n];
        int maxChunk = 0;
         int[] perm = new int[n];
        perm[0] = arr[0];
        if(perm[0] == 0)maxChunk++;

        for( int i = 1; i < n ; i++){
            prefixSum[i] = prefixSum[i-1] + i;
        }
        
        perm[0] = arr[0] ;
        for(int i = 1 ; i < n ;i++){
             perm[i] = perm[i-1] + arr[i];
            if(prefixSum[i] == perm[i])maxChunk++;
        }

        return maxChunk;

       
    }
}