class Solution {
    public int numberOfSubstrings(String s) {
      int [] freq = new int[3];
      int i = 0;
      int n = s.length();
      int count = 0;
      int j = 0;
      while(j < n){
        char ch = s.charAt(j);
        freq[ch - 'a']++;

        while((i < n) &&(freq[0] > 0 && freq[1] > 0 && freq[2] > 0)){
           count += n - j;
           char c = s.charAt(i);
           freq[c - 'a']--;
           i++;
        }
       j++; 
      }  

      return count;
    }
}