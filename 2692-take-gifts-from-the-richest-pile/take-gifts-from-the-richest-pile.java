class Solution {
    public long pickGifts(int[] gifts, int k) {
        
      ArrayList<Integer> list = new ArrayList<>();
         for( int gift : gifts){
            list.add(-gift);
         }
           
          PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        
        while( k-- > 0){
            int maxElement = -pq.poll();
            int sqRoot = (int)Math.sqrt(maxElement) ;
            pq.add(-sqRoot);
        }

        long remainingGifts = 0;

        while(pq.size() > 0){
            remainingGifts -= pq.poll();
        }

        return remainingGifts;
    }
}