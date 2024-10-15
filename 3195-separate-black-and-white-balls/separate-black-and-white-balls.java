class Solution {
    public long minimumSteps(String s) {
        
        int blacksPresent = 0;
        long  steps = 0 ;

        for(int i = 0 ; i < s.length() ;i++ ){
             if(s.charAt(i) == '0'){

                steps += (long)blacksPresent ; 
             }else{
                blacksPresent++;
             }

        }
       return steps; 
    }
}