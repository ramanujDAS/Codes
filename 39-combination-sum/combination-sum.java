class Solution {
    HashSet<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        sum(0, new ArrayList<>(), 0, candidates, target);

        List<List<Integer>> l = new ArrayList<>();

        for(List<Integer> v : ans){
            l.add(v);
        }
        return l;
    }

    private void sum(int currSum, ArrayList<Integer> curr, int index, int[] nums, int target) {

        if (currSum > target)
            return;
        if(index >= nums.length)
            return;    
        if (currSum == target) {
            ans.add(curr);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            ArrayList<Integer> t = new ArrayList<>(curr);
            t.add(nums[i]);
            sum(currSum + nums[i],t, i,nums, target);
            //t.remove(t.size()-1);
        }

    }
}