class Solution {
    public long pickGifts(int[] gifts, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for( int val : gifts){
            pq.add(val);
        }

        while( k-- > 0){
            int maxElement = pq.poll();
            System.out.println(maxElement);
            int sqRoot = (int)Math.sqrt(maxElement) ;
            pq.add(sqRoot);
        }

        long remainingGifts = 0;

        while(pq.size() > 0){
            remainingGifts += pq.poll();
        }

        return remainingGifts;
    }
}