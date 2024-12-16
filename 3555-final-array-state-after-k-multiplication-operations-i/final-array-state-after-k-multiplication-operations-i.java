class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
      
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
        int valueComp = Integer.compare(a[0] ,b[0]);

        if(valueComp == 0){
            return Integer.compare(a[1] , b[1]);
        }
        return valueComp;
        
    });

       for( int i = 0; i < nums.length; i++){
        pq.add( new int[]{nums[i] , i});
       }

       while( k-- > 0){
        int smallest [] = pq.poll();
        pq.add(new int[]{smallest[0] * multiplier , smallest[1]});
       }  

       
       while(pq.size() > 0){
        int [] element = pq.poll();

        nums[element[1]] = element[0];
       }

       return nums;


    }
}