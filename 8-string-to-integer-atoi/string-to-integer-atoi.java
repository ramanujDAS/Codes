class Solution {
    public int myAtoi(String x) {

       String s = x.trim();

        int i = 0;
        boolean isNegative = false;
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = s.charAt(i) == '-' ? true : false;
            i++;
        }

        double convertedInt = 0;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            convertedInt = convertedInt * 10 + (int) (s.charAt(i) - '0');
            i++;
        }

        if (isNegative)
            convertedInt = -1 * convertedInt;

        convertedInt = convertedInt > Integer.MAX_VALUE ? Integer.MAX_VALUE : convertedInt;
        convertedInt = convertedInt < Integer.MIN_VALUE ? Integer.MIN_VALUE : convertedInt;

        return (int)convertedInt;
    }
}