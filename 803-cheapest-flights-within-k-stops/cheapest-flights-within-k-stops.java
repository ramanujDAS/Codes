class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, src, 0}); 
        
        int [] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[src] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            int stops = current[0];  // Number of stops so far
            int node = current[1];  // Current node
            int cost = current[2];

            if(stops > k)
              continue;

           for(int [] adjNode : adj.get(node)){
              int nextNode = adjNode[0];
              int nextNodeCost = adjNode[1];
              if(stops<= k && (cost + nextNodeCost < dist[nextNode])){
                dist[nextNode] = cost + nextNodeCost;
                q.add(new int[]{stops + 1 , nextNode , cost + nextNodeCost});
              } 
           }

        }

      if(dist[dst] == Integer.MAX_VALUE)
      return -1;
      return dist[dst];
    }
}