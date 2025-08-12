class Solution {
    public int trap(int[] height) {
        int maxHeight = Integer.MIN_VALUE;

        int n = height.length;
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if(maxHeight < height[i]){
                maxPos = i;
                maxHeight = height[i];
            }
        }

      int leftMax = height[0];
      int total = 0;

      for(int i = 1; i<maxPos ;i++){
         leftMax = Math.max(leftMax , height[i]);
         total += leftMax - height[i];
      }  
      int rightMax = height[n-1];
      for(int i = n-2; i>maxPos ;i--){
         rightMax = Math.max(rightMax , height[i]);
         total += rightMax - height[i];
      }

      return total;


    }
}