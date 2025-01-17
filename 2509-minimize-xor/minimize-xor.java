class Solution {
    public int minimizeXor(int num1, int num2) {
        int result = 0;

        int targetSetBitsCount = Integer.bitCount(num2);
        int setBitsCount = 0;

        int currentBit = 31;

        while(setBitsCount < targetSetBitsCount){
            if((currentBit + setBitsCount < targetSetBitsCount)||isSet(num1 , currentBit)){
                result = result | 1 << currentBit ;
                setBitsCount++;
            }
            currentBit--;
        }
       return result; 
    }

    private boolean isSet(int num , int posBit){
        return (num & (1 << posBit)) != 0;
    }
}