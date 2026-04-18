class Solution {
    public int[] asteroidCollision(int[] as) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < as.length; i++) {
            if (as[i] > 0) {
                st.push(as[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(as[i])) {
                    st.pop();
                }
              
                if (!st.isEmpty() && st.peek() > 0 && st.peek() == Math.abs(as[i])) {
                    st.pop();
                } else if (st.isEmpty() && as[i] < 0) {
                    st.push(as[i]);
                }
                else if(!st.isEmpty() && st.peek() < 0 && as[i] < 0){
                    st.push(as[i]);
                }

            }
        }

        int[] ans = new int[st.size()];
        int i = ans.length - 1;
        while (!st.isEmpty()) {
            ans[i] = st.peek();
            i--;
            st.pop();
        }

        return ans;

    }
}