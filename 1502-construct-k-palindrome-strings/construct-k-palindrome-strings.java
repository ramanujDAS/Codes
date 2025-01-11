class Solution {
    public boolean canConstruct(String s, int k) {

        if(s.length() < k) return false;

        if(s.length() == k) return true;


        int [] charArray  = new int[26];
        int oddCount = 0;
        for(char ch : s.toCharArray()){
           int charIndexBit = 1 << (ch - 'a');
           oddCount ^=charIndexBit;
        }


        return Integer.bitCount(oddCount) <= k;
        
    }
}