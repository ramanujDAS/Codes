class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans= new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i<n ;i++){
           
            if(i>0 && nums[i] == nums[i-1])continue;

            int low = i+1;
            int high = n-1;
            
            while( low < high){
              int sum = nums[low] + nums[high] + nums[i];
               if(low == i){low++;continue;}
               if(high ==i){high--;continue;}

              if(sum < 0)low++;
              else if(sum > 0 ) high--;
              else {
               
                List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[low],nums[high]));
                ans.add(temp);
                while( low<n-1 && nums[low] == nums[low+1])low++;
                while( high>0 && nums[high] == nums[high-1])high--; 
                low++;
                high--;

              } 
            }

        }
        
     return ans; 
    }

    
}