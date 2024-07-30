class Solution {
    public String reverseWords(String s) {

        s = s.trim();
        int n = s.length();
        String ansStr = "";
        String temp = "";
        for (int i = n - 1; i >= 0; i--) {
            if (!temp.equals("") && (s.charAt(i) == (' '))) {
                ansStr += temp;
                temp = "";
                 ansStr += " ";
            } else if (s.charAt(i) == (' '))
                ansStr += "";
            else {
                temp = s.charAt(i) + temp;
            }
        }
        ansStr += temp;
        return ansStr;
    }
}