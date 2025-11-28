class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }

        int n = 0;

        int temp = x;
        while(temp>0){
            temp = temp/10;
            n++;
        }

        int left = x;
        int right = 0;

        for(int i=0; i<n/2; i++){
            int md = left%10;
            left = left / 10;
            right = 10*right + md;
        }

        if(n%2==1){
            left = left/10;
        }

        return left == right;
    }
}