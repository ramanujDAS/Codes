class Solution {
    public int[] asteroidCollision(int[] asteroids) {

      int n = asteroids.length;

      Stack<Integer> st = new Stack<>();

      for(int i = n-1 ;i >= 0 ; i--){
         
         while(!st.isEmpty() &&(st.peek() < 0) && i >= 0 && asteroids[i] > 0){
           
            if(asteroids[i] < Math.abs(st.peek())){
                i--; //skip postive no
            }
            else if(asteroids[i] > Math.abs(st.peek())){
                st.pop();// delete the negative
            }
            else{
              // both equal and opposite
              st.pop();
              i--;
            }
         }
       
       if(i >= 0)st.push(asteroids[i]); 
       else break;
      }  

     int [] ans = new int[st.size()];
      
      int i = 0;
      while(!st.isEmpty()){
        ans[i] = st.pop();
        i++;
      }
      return ans;


    }
}