class Solution {
    public int maximumLength(String s) {

        int maxLength = -1;
        // for (int len = s.length() - 1; len > 0; len--) {
        //     if (findLength(s, len))
        //         maxLength = Math.max(maxLength, len);
        // }


        // binary Search 


        int low  = 0;
        int high = s.length() -1 ;

        while(low <= high){
            int mid  = (low + high)/2;

            if(findLength(s, mid)){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return high > 0 ? high : -1;
    }

    private boolean findLength(String s, int windowSize) {
        Map<String, Integer> countMap = new HashMap<>();

        int j = 0;
        StringBuilder sb = new StringBuilder();

        while (j < s.length()) {

            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == s.charAt(j)) {
                sb.append(s.charAt(j));
            } else {
                sb = new StringBuilder();
                sb.append(s.charAt(j));
            }

            if (sb.length() > windowSize) {
                sb.deleteCharAt(0);
            }

            if (sb.length() == windowSize) {
                countMap.put(sb.toString(), countMap.getOrDefault(sb.toString(), 0) + 1);
            }

            if (countMap.getOrDefault(sb.toString(), 0) == 3)
                return true;

            j++;
        }
        return false;
    }
}