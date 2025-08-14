class Solution {
    public int sumSubarrayMins(int[] arr) {
    
      int n = arr.length;

      Stack<Integer> st = new Stack<>();

      int [] leftSmaller = new int[n];
      int [] rightSmaller = new int[n];

      for( int i = 0;i<n ;i++){
         
         while(!st.isEmpty() && arr[st.peek()] >= arr[i])
         {
            st.pop();
         }
         leftSmaller[i] = st.isEmpty() ? -1 : st.peek();
         st.push(i);

      }

      st.clear();

      for(int i = n-1; i>=0 ;i--){
        while(!st.isEmpty() && arr[st.peek()]> arr[i]){
            st.pop();
        }
        rightSmaller[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
      }
      long sum = 0;
      int mod =  1000000000+7;
      for( int i = 0 ;i < n; i++){
          int left = i - leftSmaller[i];
          int right = rightSmaller[i] - i;
          long thisSum = (long)left*(long)right*(long)arr[i];
          sum = (sum + thisSum)%mod;
      }

      return (int)sum;


    }
}