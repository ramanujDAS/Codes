class Solution {

    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        fun(nums, 0, n, k, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void fun(int[] nums, int index, int n, int k, List<Integer> list, int currSum) {
        if (index > nums.length) {
            return;
        }
        if (list.size() > k)
            return;

        if (list.size() == k && currSum == n) {
            ans.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            List<Integer> t = new ArrayList<>(list);
            t.add(nums[i]);
            fun(nums, i + 1, n, k, t, currSum + nums[i]);
        }
    }
}