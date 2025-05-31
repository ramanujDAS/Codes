class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> fourSumList = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length; j++) {
                if ((j > i + 1)&& (nums[j] == nums[j - 1]))
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {

                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {

                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        fourSumList.add(list);
                        k++;
                        l--;
                        //  while(k < n && nums[ k] == nums[k-1])continue;
                        //  while(l > 0 && nums[l] == nums[l+1])continue;
                        while ((k < l) && (nums[k] == nums[k - 1])) {
                            k++;
                            continue;
                        }
                        while ((k < l) && (nums[l] == nums[l + 1])) {
                            l--;
                            continue;
                        }

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }

                }

            }
        }
        return fourSumList;
    }
}