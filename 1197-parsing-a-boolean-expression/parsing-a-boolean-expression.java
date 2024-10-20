class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for(char currentChar : expression.toCharArray()){
            if(currentChar == ',' || currentChar == '('){
                continue;
            }
            else if(currentChar == 't' ||
               currentChar =='f' ||
               currentChar =='&' ||
               currentChar =='|' || 
               currentChar == '!'){
                stack.push(currentChar);
               }
               else if(currentChar ==')'){
               boolean containTrue = false;
               boolean containFalse = false;
                 while(stack.peek() !='!' && stack.peek()!='&' && stack.peek()!='|'){
                    char ch = stack.pop();
                   if(ch == 'f')containFalse = true;

                   if(ch == 't')containTrue = true;

                 }
               char op = stack.pop();
               Character finalValue = null;
               switch(op){
                case '!' :{
                         finalValue = containFalse ? 't' : 'f' ;
                         break;
                        }
                case '&' :{
                    finalValue = containFalse ? 'f' : 't';
                     break;
                }
                case '|' :{
                    finalValue = containTrue ? 't' : 'f';
                    break;
                }        
               }
               stack.push(finalValue);

               }


               } 
           return stack.peek() == 't';       
        }


}
