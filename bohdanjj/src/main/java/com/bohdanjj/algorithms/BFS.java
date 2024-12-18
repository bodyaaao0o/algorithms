package com.bohdanjj.algorithms;

import java.util.*;

public class BFS {
//    public static void bfs(int startNode, Map<Integer, List<Integer>> graph) {
//        Queue<Integer> queue = new LinkedList<>();
//        Set<Integer> visited = new HashSet<>();
//
//        queue.add(startNode);
//        visited.add(startNode);
//
//        while(!queue.isEmpty()) {
//            int currNode = queue.poll();
//            System.out.println("Відвідуємо вузол: " + currNode);
//            List<Integer> neighbors = graph.getOrDefault(currNode, new ArrayList<>());
//
//            for (int neighbor: neighbors) {
//                if(!visited.contains(neighbor)) {
//                    queue.add(neighbor);
//                    visited.add(neighbor);
//                }
//            }
//        }
//    }


    public static void bfs(int startNode, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            System.out.println("пройдена вершина :" + currNode);

            List<Integer> neighbors = graph.getOrDefault(currNode, new ArrayList<>());

            for (int neighbor : neighbors) {
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Граф заданий у вигляді списку суміжності.
        // Наприклад, граф:
        // 1 -> 2, 3
        // 2 -> 4, 5
        // 3 -> 6
        // 4, 5, 6 -> немає сусідів.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Arrays.asList(6));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6));
        graph.put(6, Arrays.asList());

        // Запускаємо BFS, починаючи з вузла 1.
        bfs(1, graph);
    }
}

