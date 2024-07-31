class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        fun(nums, 0, new ArrayList<>());
        return list;
    }

    void fun(int[] nums, int index, List<Integer> t) {
        list.add(new ArrayList<>(t));

        for (int i = index; i < nums.length; i++) {
            if (i != index && i > 0 && nums[i] == nums[i - 1])
                continue;

            t.add(nums[i]);
            fun(nums, i + 1, t);
            t.remove(t.size() - 1);
        }

    }
}