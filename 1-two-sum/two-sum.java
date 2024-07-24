class Solution {
    public int[] twoSum(int[] nums, int target) {
        
       Map<Integer,Integer> set= new HashMap<>();
        int[] ans= new int[2];
       
       for(int i=0;i<nums.length;i++)
       {
          if(set.containsKey(target-nums[i])){
              ans[0]=i;
              ans[1]=set.get(target-nums[i]);
              return ans; }
          else{
              set.put(nums[i],i);
          } 
       }
       return ans; 
    }
}