class Solution {
    public long findScore(int[] nums) {

        long ans = 0;
        boolean[] marked = new boolean[nums.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> {
            if (arr1[0] != arr2[0])
                return arr1[0] - arr2[0];

            return arr1[1] - arr2[1];
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }

        while (pq.size() > 0) {
            int[] smallestElement = pq.poll();
            int num = smallestElement[0];
            int index = smallestElement[1];

            if (!marked[index]) {
                marked[index] = true;

                ans += num;
                if (index - 1 >= 0) {
                    marked[index - 1] = true;
                }

                if (index + 1 <= nums.length - 1) {
                    marked[index + 1] = true;
                }
            }
        }
        return ans;
    }
}