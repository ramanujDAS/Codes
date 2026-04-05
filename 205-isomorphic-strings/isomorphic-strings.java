class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            char currChar1 = t.charAt(i);
            if (map.containsKey(currChar)) {
                if (map.get(currChar) != currChar1)
                    return false;
            } else {
                if(set.contains(currChar1))
                     return false;
                map.put(currChar, currChar1);
                set.add(currChar1);
            }
        }

        return true;
    }
}