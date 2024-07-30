class Solution {
   List<List<Integer>> answer= new ArrayList<>(); 
    public List<List<Integer>> subsets(int[] nums) {

       fun(nums,0,new ArrayList<Integer>());
        return answer;
    }

   void fun(int [] nums,int index,List<Integer> t){
     answer.add(new ArrayList<>(t));
     
     for(int i=index;i<nums.length;i++){
        t.add(nums[i]);
        fun(nums,i+1,t);
        t.remove(t.size()-1);
     } 
     
        } 
}