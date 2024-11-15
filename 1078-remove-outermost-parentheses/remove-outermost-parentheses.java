class Solution {
    public String removeOuterParentheses(String s) {

        Stack<Character> charStack = new Stack<>();

        StringBuilder ansString = new StringBuilder("");

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (charStack.size() > 0) {
                    ansString.append("(");
                }

                charStack.push('(');

            } else {

                charStack.pop();

                if (charStack.size() > 0)
                    ansString.append(")");

            }

        }
        return ansString.toString();
    }
}