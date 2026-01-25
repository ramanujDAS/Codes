class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        if (n - 1 == 0 && m - 1 == 0)
            return 1;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        dist[0][0] = 0;

        q.add(new int[] { 1, 0, 0 });// minDist , starti,startj;

        int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int dis = node[0];
            int indexi = node[1];
            int indexj = node[2];

            for (int i = 0; i < 8; i++) {
                int newDis = dis + 1;
                int newIndexi = indexi + dr[i];
                int newIndexj = indexj + dc[i];
                if (newIndexi == n - 1 && newIndexj == m - 1)
                    return newDis;
                if (newIndexi >= 0 && newIndexi < n && newIndexj >= 0 && newIndexj < m
                        && grid[newIndexi][newIndexj] == 0
                        && newDis < dist[newIndexi][newIndexj]) {
                    dist[newIndexi][newIndexj] = newDis;
                    q.add(new int[] { newDis, newIndexi, newIndexj });
                }
            }
        }

        if (dist[n - 1][m - 1] == Integer.MAX_VALUE)
            return -1;

        return dist[n - 1][m - 1];

    }

}
