class Solution {
    public boolean primeSubOperation(int[] nums) {
       
       int maxElement = Integer.MIN_VALUE ;
    
      
       
       for( int num : nums){
        maxElement = Math.max(maxElement , num);
       }
        int [] primePrev = new int[maxElement + 1];
       for( int i = 2 ; i <= maxElement ; i++){
           
           if(isPrime(i)){
            primePrev[i] = i;
           }
           else{
            primePrev[i] = primePrev[ i -1 ];
           }
       }

      for( int i =0; i< nums.length ;i++){
          
         int diff = 0;

         if(i == 0){
            diff = nums[i];
         }else{
            diff = nums[i] - nums[ i -1];
         } 

         if(diff <=0) return false;

         int maxPrime = primePrev[diff - 1];

         nums[i] -= maxPrime;

      }
     return true;

    }

    boolean isPrime(int num){

        for( int i = 2 ; i*i <= num ;i++ ){
            if(num % i == 0) return false;
        }

       return true; 
    }
}