class Solution {
    public String removeKdigits(String num, int k) {
      
      int len = num.length();
       
       if(k == len) return "0";

       Stack<Character> stack = new Stack<>();

      
       for( int i =0 ;i< len ;i++){
            while( k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
              stack.pop();
              k--;
            }

            stack.push(num.charAt(i));
       }


      while( k > 0 && !stack.isEmpty()){
        stack.pop();
        k--;
      }
     String numAfterRemoval = "";

     while(!stack.isEmpty()){
        numAfterRemoval = stack.pop() + numAfterRemoval;
     }

     while(numAfterRemoval.length() > 1 && numAfterRemoval.charAt(0) == '0'){
        numAfterRemoval = numAfterRemoval.substring(1);
     }

     return numAfterRemoval;



    }
}