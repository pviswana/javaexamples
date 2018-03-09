package com.algorithms.standard.graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * The topological sort is generally used during build process where
 * you need to make sure that the module dependency is honored and the
 * dependent module is built only after the dependency modules are all built before that.
 *
 * You do a DFS traversal and on the way push vertices to a stack. Once you reach a vertex
 * that has no adjacent vertices, you know that is the last one to be built in that path.
 * So you then pop the stack and process the parent of that Vertex and then go the
 * adjacent vertices thus recursively getting to all the vertices.
 */
public class GraphTopologicalSort<T> {
    public Deque<Vertex<T>> topSort(Graph<T> graph) {
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();

        for (Vertex<T> vertex : graph.getAllVertex()) {
            if (visited.contains(vertex)) {
                continue;
            }
            topSortUtil(vertex, stack, visited);
        }
        return stack;
    }

    private void topSortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
        visited.add(vertex);

        for (Vertex<T> childVertex : vertex.getAdjacentVertexes()) {
            if (visited.contains(childVertex)) {
                continue;
            }
            topSortUtil(childVertex, stack,visited );
        }
        stack.offerFirst(vertex);
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1,3 );
        graph.addEdge(1,2 );
        graph.addEdge(3,4 );
        graph.addEdge(5,6 );
        graph.addEdge(6,3 );
        graph.addEdge(3,8 );
        graph.addEdge(8,11 );

        GraphTopologicalSort<Integer> graphTopologicalSort = new GraphTopologicalSort<>();
        Deque<Vertex<Integer>> result = graphTopologicalSort.topSort(graph);

        while (!result.isEmpty()) {
            System.out.println(result.poll());
        }
    }
}

