class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        sum(candidates, 0, target, new ArrayList<Integer>(), 0);
        return ans;

    }

    public void sum(int[] sum, int index, int target, ArrayList<Integer> curr, int currSum) {
        if (currSum > target)
            return;

        if (index > sum.length)
            return;

        if (currSum == target) {
            ans.add(curr);
            return;
        }

        for (int i = index; i < sum.length; i++) {
            if(i > index && sum[i] == sum[i-1])continue;
           ArrayList<Integer> t = new ArrayList<>(curr);
            t.add(sum[i]);
            sum(sum, i + 1, target, t, currSum + sum[i]);
        }

    }
}