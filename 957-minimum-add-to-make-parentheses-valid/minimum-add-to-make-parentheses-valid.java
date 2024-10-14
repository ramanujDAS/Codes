class Solution {
    public int minAddToMakeValid(String s) {
        
        int openingBrackets = 0;
        int addition = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                openingBrackets++;
            }else{
                if(openingBrackets > 0){
                    openingBrackets--;
                }
                else {
                    addition++;
                }
            }
        }
      return openingBrackets + addition ;  
    }
}