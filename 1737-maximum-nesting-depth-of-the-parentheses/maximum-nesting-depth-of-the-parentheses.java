class Solution {
    public int maxDepth(String s) {

        Stack<Character> bracketStack = new Stack<>();
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                bracketStack.push(ch);
            }

            if (ch == ')') {
                bracketStack.pop();
            }
            maxDepth = Math.max(maxDepth, bracketStack.size());
        }

        return maxDepth;
    }
}