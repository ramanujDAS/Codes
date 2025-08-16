class Solution {
    public int maximum69Number (int num) {
        String numsStr = Integer.toString(num);
        String str = numsStr.replaceFirst("6" ,"9") ;
        return Integer.parseInt(str);
    }
}