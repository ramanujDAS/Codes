class Solution {
    public String longestCommonPrefix(String[] strs) {
        
     String longestCommonPrefix  = "";
     int minLength  = 210 ;
     for( int i = 0 ;i < strs.length ;i++){
        minLength = Math.min(minLength , strs[i].length());
     }

     int StringIndex = 0;
     boolean notMatched = false; 
      for( int i = 0;i < minLength ; i++){
          char ch = strs[0].charAt(i);
          for(String str : strs){
              if(ch != str.charAt(i)){
                notMatched = true;
                break;
              }
        }
        if(notMatched)
        break;
        
        longestCommonPrefix += ch ;

         
        }

     return longestCommonPrefix;
    }
}