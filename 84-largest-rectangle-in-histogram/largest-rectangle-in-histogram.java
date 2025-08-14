class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
       int [] leftSmaller = new int[n];
       int [] rightSmaller = new int[n];

       Stack<Integer> st = new Stack<>();

       for(int i =0 ; i< n ;i++){
         
         while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
            st.pop();
         }
         leftSmaller[i] = st.isEmpty() ? -1 : st.peek();
         st.push(i);
       } 
       st.clear();
       for(int i = n - 1 ; i>=0 ;i--){
        while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
            st.pop();
        }
        rightSmaller[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
       }

       int  rectangle = 0 ;

       for(int i = 0;i<n ;i++){
        int width = rightSmaller[i] - leftSmaller[i] -1;
        rectangle = Math.max(rectangle , width * heights[i]);
       }
       return rectangle;
    }
}