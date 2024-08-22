class Solution {
    public int findComplement(int num) {
        int len = 0;
        int n = num;
        while(n > 0){
            n = n/2 ;
            len++;
        }
       int setBits =(int) (Math.pow(2,len) -1);

       return num ^ setBits ;

    }
}