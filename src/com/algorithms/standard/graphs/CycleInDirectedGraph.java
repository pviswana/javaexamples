package com.algorithms.standard.graphs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CycleInDirectedGraph {
    public boolean hasCycle(Graph<Integer> graph) {
        Set<Vertex<Integer>> unProcessed = new HashSet<>();
        Set<Vertex<Integer>> inProgress = new HashSet<>();
        Set<Vertex<Integer>> processed = new HashSet<>();

        Collection<Vertex<Integer>> allVertex = graph.getAllVertex();

        for (Vertex<Integer> vertex : allVertex) {
            unProcessed.add(vertex);
        }

        while(!unProcessed.isEmpty()) {
            Vertex<Integer> vertex = unProcessed.iterator().next();
            if (dfs(vertex, unProcessed, inProgress, processed)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(Vertex<Integer> current, Set<Vertex<Integer>> unProcessed, Set<Vertex<Integer>> inProgress, Set<Vertex<Integer>> processed) {
        moveVertex(current, unProcessed, inProgress);

        for (Vertex<Integer> neighbor : current.getAdjacentVertexes()) {
            if (processed.contains(neighbor)) {
                continue;
            }

            if (inProgress.contains(neighbor)) {
                return true;
            }

            if (dfs(neighbor,unProcessed ,inProgress ,processed )) {
                return true;
            }
        }
        moveVertex(current,inProgress ,processed );
        return false;
    }

    private void moveVertex(Vertex<Integer> current, Set<Vertex<Integer>> source, Set<Vertex<Integer>> dest) {
        source.remove(current);
        dest.add(current);
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);

        CycleInDirectedGraph cycleInDirectedGraph = new CycleInDirectedGraph();
        System.out.println(cycleInDirectedGraph.hasCycle(graph));
    }
}
