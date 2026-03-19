class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        HashSet<List<Integer>> list = new HashSet<>();

        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int low = j + 1;
                int high = n - 1;

                while (low < high) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[low] + (long)nums[high];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }

            }
        }
        List<List<Integer>> fourSum = new ArrayList<>(list);

        return fourSum;

    }
}