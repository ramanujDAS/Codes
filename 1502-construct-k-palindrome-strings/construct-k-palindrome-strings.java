class Solution {
    public boolean canConstruct(String s, int k) {

        if(s.length() < k) return false;

        if(s.length() == k) return true;


        int [] charArray  = new int[26];

        for(char ch : s.toCharArray()){
            charArray[ch - 'a']++;
        }

        int oddCount = 0;

        for(int i = 0; i< 26 ; i++)
        {
            if(charArray[i] % 2 == 1)oddCount++;
        }

        return oddCount <= k;
        
    }
}