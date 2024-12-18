package com.bohdanjj.algorithms;
import java.util.*;

public class DFS {

    public static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        System.out.println("Відвідуємо :" + node);

        List<Integer> neighbors = graph.getOrDefault(node, new ArrayList<>());

        for (int neighbor : neighbors) {
            if(!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6, 7));
        graph.put(4, Arrays.asList(8));
        graph.put(5, Arrays.asList(6));
        graph.put(6, Arrays.asList(9));
        graph.put(7, Arrays.asList(9));
        graph.put(8, Arrays.asList());
        graph.put(9, Arrays.asList(10));
        graph.put(10, Arrays.asList(3));

        Set<Integer> visited = new HashSet<>();

        dfs(1, graph, visited);
    }
}
