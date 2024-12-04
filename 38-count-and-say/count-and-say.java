class Solution {
    public String countAndSay(int n) {

        return calcRle(n);
    }

    String calcRle(int n) {
        if (n == 1)
            return "1";

        String countSayString = calcRle(n - 1);

        int i = 0;
        int countValue = 1;
        String foundString = "";
        while (i < countSayString.length() - 1) {
            if (countSayString.charAt(i) == countSayString.charAt(i + 1)) {
                countValue++;
                
            } else {
                foundString += "" + countValue + "" + countSayString.charAt(i);
                countValue = 1;

            }
            i++;
        }
        foundString += "" + countValue + "" + countSayString.charAt(i);
        return foundString;
    }
}