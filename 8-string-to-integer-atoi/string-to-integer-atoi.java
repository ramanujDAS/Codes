class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        if (s.length() == 0)
            return 0;

        long ans = 0;

        int sign = 1;
        int i = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-')
                sign = -1;

            i++;
        }

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int val = ch - '0';
                ans = ans * 10 + val;
            } else {
                break;
            }

            if(ans*sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(ans*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        if (ans * sign > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (ans * sign < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) ans * sign;
    }
}