class Solution {
    public String fractionAddition(String ex) {

        int denom =1;
        int num = 0;
       
        for (int i = 0; i < ex.length();i=i) {

          boolean isNegative = false;
            if (ex.charAt(i) == '-' || ex.charAt(i)=='+') {
            if(ex.charAt(i) == '-')
                isNegative = true;

                i++;
           }
           int currNum = 0;
           while(Character.isDigit(ex.charAt(i))){
            int val = ex.charAt(i) -'0';
              currNum = currNum*10 + val;
              i++;
           }
           if(isNegative) currNum *= -1;

           i++;

           int currDenom =0;
          while(i<ex.length() && Character.isDigit(ex.charAt(i))){
             int val = ex.charAt(i) - '0';
             currDenom = currDenom * 10 + val ;
             i++;
          } 
          num = num * currDenom + denom * currNum ;
          denom = denom * currDenom;
       
        }
     
        int gcd = getGcd(denom,Math.abs(num)) ;
       

            num = num / gcd ;
            denom = denom / gcd;


          return num +"/"+denom ;  
    }

    int getGcd(int Num2, int Num1) {
        if(Num2 == 0) return Num1;
        while (Num2 != 0) {
           int Temp = Num2;
            Num2 = Num1 % Num2;
            Num1 = Temp;
        }
        return Num1;
    }
    //  private int getGCD(int a, int b) {
    //     if (a == 0) return b;
    //     return getGCD(b % a, a);
    // }
}