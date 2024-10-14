class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans =0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for( int i : nums){
            pq.add(i);
        }

        while(k-- > 0){
            int elementMax = pq.poll();
            ans += elementMax;
            pq.add((int)Math.ceil(elementMax/3.0));
        }

        return ans;

    }
}