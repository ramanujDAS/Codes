class Solution {
    public String removeKdigits(String num, int k) {

        if (k == num.length())
            return "0";

        Stack<Character> stack = new Stack<>();

        int deleted = 0;

        for (int i = 0; i < num.length(); i++) {

            char value = num.charAt(i);
            while (deleted < k && (!stack.isEmpty() && stack.peek() > value)) {
                stack.pop();
                deleted++;
            }

            stack.push(value);

        }

        while(deleted < k){
            stack.pop();
            deleted++;
        }

        StringBuilder digits = new StringBuilder();

        while (!stack.isEmpty()) {
            digits.append(stack.pop());
        }

        digits.reverse();
      
        while(digits.length() > 1 && digits.charAt(0) =='0'){
            digits.deleteCharAt(0);
        }

        return digits.toString() ;

    }
}