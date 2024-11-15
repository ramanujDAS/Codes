class Solution {
    public String reverseWords(String s) {

        s = s.trim();
        int n = s.length();
        StringBuilder reverseStr = new StringBuilder();
        String temp = "";
        for (int i = n - 1; i >= 0; i--) {
            if (!temp.equals("") && (s.charAt(i) == (' '))) {
                reverseStr.append(temp);
                temp = "";
                reverseStr.append(" ");
            } else if (s.charAt(i) == (' '))
                reverseStr.append("");
            else {
                temp = s.charAt(i) + temp;
            }
        }
        reverseStr.append(temp);
        return reverseStr.toString();
    }
}