class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        fun(s, 0, new ArrayList<String>());
        return ans;
    }

    private void fun(String s, int index, List<String> curr) {
        if (index > s.length())
            return;

        if (index == s.length()) {
            ans.add(curr);
            return;
        }
        String currStr = new String();
        for (int i = index; i < s.length(); i++) {

            currStr += s.charAt(i);
            if (!isPalid(currStr))
                continue;
            ArrayList<String> g = new ArrayList<>(curr);
            g.add(currStr);
            fun(s, i + 1, g);
        }

    }

    private boolean isPalid(String str) {
        if (str.length() == 0)
            return false;

        int low = 0;
        int high = str.length() - 1;

        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}