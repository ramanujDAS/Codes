class Solution {
    public int networkDelayTime(int[][] flights, int n, int k) {
         List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]-1).add(new int[] { flight[1]-1, flight[2] });
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a , b)-> a[2] - b[2]);
        q.add(new int[] { 0, k-1, 0 });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k-1] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int stops = current[0]; // Number of stops so far
            int node = current[1]; // Current node
            int cost = current[2];

            for (int[] adjNode : adj.get(node)) {
                int nextNode = adjNode[0];
                int nextNodeCost = adjNode[1];
                if (cost + nextNodeCost < dist[nextNode]) {
                    dist[nextNode] = cost + nextNodeCost;
                    q.add(new int[] { stops + 1, nextNode, cost + nextNodeCost });
                }
            }

        }
       int ans = Integer.MIN_VALUE;
       for(int ds : dist){
         if(ds == Integer.MAX_VALUE)
         return -1;
         if(ds > ans){
            ans = ds;
         }
       }
        return ans;
    }
}