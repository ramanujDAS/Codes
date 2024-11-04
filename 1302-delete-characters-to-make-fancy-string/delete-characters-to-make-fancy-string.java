class Solution {
    public String makeFancyString(String s) {
        
        StringBuilder fancyString  = new StringBuilder("");

        if( s.length() <= 2 ) return s;
   
       fancyString.append(s.charAt(0) + "" +s.charAt(1)) ;
    

      for( int i = 2;i< s.length() ; i++){
         
         if((s.charAt(i) == s.charAt(i-1)) && (s.charAt(i-1) == s.charAt(i-2)))continue;

         else fancyString.append(s.charAt(i)+"");  

      }
    return fancyString.toString();
      
    }
}