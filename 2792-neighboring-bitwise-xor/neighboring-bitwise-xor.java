class Solution {
    public boolean doesValidArrayExist(int[] derived) {

        int n = derived.length;
        int res = 0; 
        for( int val : derived ){
            res ^= val;
        }


        return res == 0;

    }
}