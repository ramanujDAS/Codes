class Solution {
    public int prefixCount(String[] words, String pref) {
        
       int count = 0;

       for(String word : words){
          int index = word.indexOf(pref);
          if(index == 0)
             count++;
       }
      return count; 
    }
}