class Solution {
    private int[] parent;
    private int[] size;

    public int makeConnected(int n, int[][] edges) {

        parent = new int[n];
        size = new int[n];
        if (edges.length < n - 1)
            return -1;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            union(u, v);
        }

        HashSet<Integer> component = new HashSet<>();
        for (int node : parent)
            component.add(findParent(node));

       
        return component.size() - 1;

    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    private void union(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (uParent == vParent) {
            return;
        }
        if (size[uParent] < size[vParent]) {
            parent[uParent] = vParent;
            size[vParent] = size[uParent] + size[vParent];
        } else {
            parent[vParent] = uParent;
            size[uParent] = size[uParent] + size[vParent];
        }
    }

}