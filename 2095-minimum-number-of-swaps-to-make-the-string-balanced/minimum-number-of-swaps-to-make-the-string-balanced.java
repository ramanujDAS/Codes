class Solution {
    public int minSwaps(String s) {
        int unBalanced = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '[') {
                stack.push('[');
            } else {
                if (stack.size() > 0) {
                    stack.pop();
                } else {
                    unBalanced++;
                }
            }
        }
        return (unBalanced +1 ) / 2;
    }
}