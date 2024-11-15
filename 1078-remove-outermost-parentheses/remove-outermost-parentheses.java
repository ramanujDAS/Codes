class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> charStack = new Stack<>();

        String ansString = "";

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (charStack.size() > 0) {
                    ansString += "(";
                }

                charStack.push('(');

            } else {

                charStack.pop();

                if (charStack.size() > 0)
                    ansString += ")";

            }

        }
        return ansString;
    }
}