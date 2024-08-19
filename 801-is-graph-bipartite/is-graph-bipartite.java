class Solution {
    public boolean isBipartite(int[][] graph) {
        int colr = 1;
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0)
                if (!fun(graph, i, color, 1))
                    return false;
        }
        return true;
    }

    boolean fun(int[][] graph, int index, int[] color, int colr) {

        color[index] = colr;

        for (int i = 0; i < graph[index].length; i++) {

            if (color[graph[index][i]] == 0) {

                if (!fun(graph, graph[index][i], color, -1 * colr))
                    return false;
            } else {
                if (color[graph[index][i]] == colr)
                    return false;
            }

        }
        return true;
    }

}