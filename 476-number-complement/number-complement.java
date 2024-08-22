class Solution {
    public int findComplement(int num) {
        long len = 0;
        long n = num;
        while(n > 0){
            n = n/2 ;
            len++;
        }
       long setBits =(long)Math.pow(2,len) -1;

       return (int)num ^ (int)setBits ;

    }
}