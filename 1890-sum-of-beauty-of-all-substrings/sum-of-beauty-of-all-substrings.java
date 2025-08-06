class Solution {
    public int beautySum(String s) {
        int[] chArray = new int[26];
        int totalSum = 0;
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(chArray, 0);
            for (int j = i; j < s.length(); j++) {
                chArray[s.charAt(j) - 'a']++;

                int minCount = Integer.MAX_VALUE;
                int maxCount = Integer.MIN_VALUE;

                for (int k = 0; k < 26; k++) {
                    if (chArray[k] > 0) {
                        minCount = Math.min(minCount, chArray[k]);
                    }
                    if (chArray[k] > 0) {
                        maxCount = Math.max(maxCount, chArray[k]);
                    }
                }

                totalSum += Math.abs(maxCount - minCount);
            }
        }
        return totalSum;
    }

}
