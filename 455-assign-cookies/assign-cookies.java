class Solution {
    public int findContentChildren(int[] g, int[] s) {

       int i = 0;
       int  j = 0;
       Arrays.sort(s);
       Arrays.sort(g);
       int contentCount = 0;
       while(j < s.length && i < g.length){
          if(s[j] >= g[i]){
            i++;
            j++;
            contentCount++;
          }
          else{
            j++;
          }  
       }
       return contentCount;  
    }
}