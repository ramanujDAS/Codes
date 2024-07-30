class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int n = nums2.length;
     // int[] ans = new int[n] ;
      Stack<Integer> st = new Stack<>();
      HashMap<Integer,Integer> ans = new HashMap<>();
      for(int i = n-1 ;i>=0 ;i--){
          while(!st.isEmpty() && st.peek()<=nums2[i]){
            st.pop();
          }
         if(st.isEmpty()){
            ans.put(nums2[i],-1);
         }else{
            ans.put(nums2[i],st.peek());
         }
        st.push(nums2[i]);

      }
     int [] anslist = new int[nums1.length];
      for(int i = 0; i< nums1.length ;i++ ){
        anslist[i] = ans.getOrDefault(nums1[i],-1);
      }
      return anslist;
    }
}