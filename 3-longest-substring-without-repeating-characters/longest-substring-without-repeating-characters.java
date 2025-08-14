class Solution {
    public int lengthOfLongestSubstring(String s) {

      int i = 0;
      int j = 0;
      int maxLength = 0;
      HashSet<Character>  charSet = new HashSet<>();

      while(j < s.length()){
          char ch = s.charAt(j);
          while(charSet.contains(ch))
           {
             charSet.remove(s.charAt(i));
             i++;
           } 
         charSet.add(ch);
         maxLength = Math.max(maxLength , j - i +1);
         j++;

      }

      return maxLength;

    }
}