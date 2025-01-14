class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

       int n = A.length;
       int [] freqArray = new int[n + 1];
       int [] prefixCommonArray = new int[n];
       int prefixCount = 0;
       for( int i = 0; i < n ;i++){
        
         freqArray[A[i]]++;
         if(freqArray[A[i]] == 2)prefixCount++;

         freqArray[B[i]]++;

         if(freqArray[B[i]] == 2) prefixCount++;

        prefixCommonArray[i] = prefixCount;
       } 

       return prefixCommonArray;
    }
}