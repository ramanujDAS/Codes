class Solution {
    public boolean isAnagram(String s, String t) {
       
        int[] freqArray = new int[26];
        for(char ch : s.toCharArray()){
            freqArray[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            freqArray[ch - 'a']--;
        }
         
        
       for(int i = 0; i < 26; i++){
           if(freqArray[i] != 0)return false;
       } 
        return true;
    }
}