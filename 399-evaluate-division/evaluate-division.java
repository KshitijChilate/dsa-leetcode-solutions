import java.util.*;

class Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        // Step 1: Build graph
        Map<String, List<Pair>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            
            graph.get(a).add(new Pair(b, val));
            graph.get(b).add(new Pair(a, 1.0 / val));
        }

        // Step 2: Process queries
        double[] result = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                result[i] = -1.0;
            } else if (start.equals(end)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, start, end, 1.0, visited);
            }
        }
        
        return result;
    }

    private double dfs(Map<String, List<Pair>> graph, String curr, String target, double product, Set<String> visited) {
        
        visited.add(curr);
        
        for (Pair neighbor : graph.get(curr)) {
            if (visited.contains(neighbor.node)) continue;
            
            double newProduct = product * neighbor.value;
            
            if (neighbor.node.equals(target)) {
                return newProduct;
            }
            
            double res = dfs(graph, neighbor.node, target, newProduct, visited);
            if (res != -1.0) return res;
        }
        
        return -1.0;
    }

    static class Pair {
        String node;
        double value;
        
        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }
}