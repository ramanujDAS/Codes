class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        sum(nums, 0, 0, new ArrayList<Integer>(), 0);
        return ans;
    }

    public void sum(int[] sum, int index, int target, ArrayList<Integer> curr, int currSum) {

        if (index > sum.length)
            return;

        ans.add(curr);

        for (int i = index; i < sum.length; i++) {
            if (i > index && sum[i] == sum[i - 1])
                continue;
            ArrayList<Integer> t = new ArrayList<>(curr);
            t.add(sum[i]);
            sum(sum, i + 1, target, t, currSum + sum[i]);
        }

    }
}