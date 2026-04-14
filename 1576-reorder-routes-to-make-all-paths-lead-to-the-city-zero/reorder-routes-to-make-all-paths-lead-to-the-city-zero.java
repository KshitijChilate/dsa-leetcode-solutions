import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] conn : connections) {
            int a = conn[0], b = conn[1];
            graph.get(a).add(new int[]{b, 1}); // original direction
            graph.get(b).add(new int[]{a, 0}); // reverse direction
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : graph.get(node)) {
            int next = neighbor[0];
            int cost = neighbor[1];

            if (!visited[next]) {
                changes += cost + dfs(next, graph, visited);
            }
        }

        return changes;
    }
}