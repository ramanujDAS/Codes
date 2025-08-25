class Solution {
    public int minBitFlips(int start, int goal) {
      int flippedCount = 0;

      int c = start ^ goal ;

      while(c > 0){
        c = c & (c-1);
        flippedCount++;
      } 

      return flippedCount; 
    }
}