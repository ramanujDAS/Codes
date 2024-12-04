class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        
        int j = 0;
        boolean isSubsuequence = false;

        for( int i = 0; i< str1.length() ; i++){

            int index = 'a' + ((str1.charAt(i) - 'a') + 1)%26;
             if(str1.charAt(i) == str2.charAt(j) || str2.charAt(j) == (char)(index))
             {
                j++;
             }
             if( j == str2.length())break;
        }

        if(j == str2.length()) return true;
        return false;
    }
}