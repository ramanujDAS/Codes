class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                if (ch == '(')
                    stack.push(')');
                if (ch == '{')
                    stack.push('}');
                if (ch == '[')
                    stack.push(']');
            } else {
                if(stack.isEmpty())return false;
                if (stack.pop() != ch)
                    return false;
            }
        }

        return stack.isEmpty();

    }
}