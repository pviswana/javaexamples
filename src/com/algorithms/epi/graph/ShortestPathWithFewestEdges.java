package com.algorithms.epi.graph;

import java.util.*;

public class ShortestPathWithFewestEdges {
    public void dijkstraShortestPath(GraphVertex s, GraphVertex t) {
        SortedSet<GraphVertex> nodeSet = new TreeSet<>();
        s.distanceWithFewestEdges = new DistanceWithFewestEdges(0, 0);
        nodeSet.add(s);

        while(!nodeSet.isEmpty()) {
            GraphVertex u = nodeSet.first();
            if (u.equals(t)) {
                return;
            }
            nodeSet.remove(nodeSet.first());

            for (VertexWithDistance v : u.edges) {
                int vDistance = u.distanceWithFewestEdges.distance + v.distance;
                int vMinEdges = u.distanceWithFewestEdges.minNumEdges + 1;

                if (v.vertex.distanceWithFewestEdges.distance > vDistance ||
                        (v.vertex.distanceWithFewestEdges.distance == vDistance &&
                          v.vertex.distanceWithFewestEdges.minNumEdges > vMinEdges)) {
                    nodeSet.remove(v.vertex);
                    v.vertex.pred = u;
                    v.vertex.distanceWithFewestEdges = new DistanceWithFewestEdges(vDistance, vMinEdges);
                    nodeSet.add(v.vertex);
                }
            }
        }

        outputShortestPath(t);
    }

    private void outputShortestPath(GraphVertex t) {
        if (t != null) {
            outputShortestPath(t.pred);
            System.out.println(t.id + " ");
        }
    }
}

class VertexWithDistance {
    public GraphVertex vertex;
    public Integer distance;

    public VertexWithDistance(GraphVertex vertex, Integer distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
}

class DistanceWithFewestEdges {
    public Integer distance;
    public Integer minNumEdges;

    public DistanceWithFewestEdges(Integer distance, Integer minNumEdges) {
        this.distance = distance;
        this.minNumEdges = minNumEdges;
    }
}

class GraphVertex implements Comparable<GraphVertex>{
    public DistanceWithFewestEdges distanceWithFewestEdges =
            new DistanceWithFewestEdges(Integer.MAX_VALUE, 0);
    public List<VertexWithDistance> edges = new ArrayList<>();
    public int id;
    public GraphVertex pred;

    @Override
    public int compareTo(GraphVertex o2) {
        if (distanceWithFewestEdges.distance != o2.distanceWithFewestEdges.distance) {
            return Integer.compare(distanceWithFewestEdges.distance, o2.distanceWithFewestEdges.distance );
        }

        if (distanceWithFewestEdges.minNumEdges != o2.distanceWithFewestEdges.minNumEdges) {
            return Integer.compare(distanceWithFewestEdges.minNumEdges, o2.distanceWithFewestEdges.minNumEdges);
        }
        return Integer.compare(id, o2.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GraphVertex)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        GraphVertex that = (GraphVertex)obj;
        return id == that.id &&
                distanceWithFewestEdges.distance == that.distanceWithFewestEdges.distance &&
                distanceWithFewestEdges.minNumEdges == that.distanceWithFewestEdges.minNumEdges;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distanceWithFewestEdges.distance, distanceWithFewestEdges.minNumEdges, id);
    }
}
