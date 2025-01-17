class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        int n = derived.length;

        int[] original = new int[n];

        original[0] = 0;
        // assume first elemnt is zero. D[i] = orignial[i] ^ orignal[i+1];
        // by cummlative property orginal[i+1]= D[i] ^ orginal[i];

        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }

        if (derived[n - 1] == (original[n - 1] ^ original[0]))
            return true;


        original[0] = 1;

        for(int i =0 ;i < n -1 ;i++){
            original[i +1] = derived[i] ^ original[i] ;
        }

        if( derived[n-1] == (original[n-1] ^original[0])) 
        return true;

        return false;
            

    

    }
}