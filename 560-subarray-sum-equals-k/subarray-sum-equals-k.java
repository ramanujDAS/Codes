class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> set = new HashMap<>();
        int prefix = 0;
        int count = 0;
        set.put(0 , 1);
        for (int num : nums) {
            prefix += num;

            int afterRemoveK = prefix - k;

            if (set.containsKey(afterRemoveK)) {
                count += set.get(afterRemoveK);
            }

            set.put(prefix, set.getOrDefault(prefix, 0) + 1);

        }

        return count;

    }
}