package com.bohdanjj.algorithms;

import java.util.*;


public class Dijkstra {

    public static void dijkstra(int startNode, Map<Integer, List<Edge>> graph) {
        Map<Integer, Integer> distancce = new HashMap<>();

        for (int node: graph.keySet()) {
            distancce.put(node, Integer.MAX_VALUE);
        }

        distancce.put(startNode, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        priorityQueue.add(new Edge(startNode, 0));

        while(!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            int currentNode = current.to;
            int currentDistsnce = current.weight;

            for (Edge neighbor: graph.getOrDefault(currentNode, new ArrayList<>())) {
                int newDisnatce = currentDistsnce + neighbor.weight;

                if (newDisnatce < distancce.get(neighbor.to)) {
                    distancce.put(neighbor.to, newDisnatce);
                    priorityQueue.add(new Edge(neighbor.to, newDisnatce));
                }
            }
        }

        for (int node: distancce.keySet()) {
            System.out.println("Відстань від " + startNode + " до " + node + " = " + distancce.get(node));
        }

    }

    static class Edge {
        int to;
        int weight;

        Edge(int to,int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {

        Map<Integer, List<Edge>> graph = new HashMap<>();

        graph.put(1, Arrays.asList(
                new Edge(2, 2), new Edge(3, 4), new Edge(4, 1)
        ));

        graph.put(2, Arrays.asList(
                new Edge(3, 1), new Edge(5, 7)
        ));

        graph.put(3, Arrays.asList(
                new Edge(4, 3), new Edge(6, 5)
        ));

        graph.put(4, Arrays.asList(
                new Edge(5, 1), new Edge(6, 9)
        ));

        graph.put(5, Arrays.asList(
                new Edge(7, 6)
        ));

        graph.put(6, Arrays.asList(
                new Edge(7, 2)
        ));

        graph.put(7, new ArrayList<>());

        dijkstra(1, graph);
    }

}
