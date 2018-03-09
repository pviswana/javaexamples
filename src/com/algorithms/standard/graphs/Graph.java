package com.algorithms.standard.graphs;

import java.util.*;

public class Graph<T> {
    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertex;
    private boolean isDirected = false;

    public Graph(boolean isDirected) {
        allEdges = new ArrayList<Edge<T>>();
        allVertex = new HashMap<Long, Vertex<T>>();
        this.isDirected = isDirected;
    }

    public void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0 );
    }

    public void addEdge(long id1, long id2, int weight) {
        Vertex<T> vertex1 = null;
        if (allVertex.containsKey(id1)) {
            vertex1 = allVertex.get(id1);
        } else {
            vertex1 = new Vertex<>(id1);
            allVertex.put(id1, vertex1);
        }

        Vertex<T> vertex2 = null;
        if (allVertex.containsKey(id2)) {
            vertex2 = allVertex.get(id2);
        } else {
            vertex2 = new Vertex<>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1, vertex2, isDirected, weight);
        allEdges.add(edge);

        vertex1.addAdjacentVertex(edge, vertex2 );
        if (!isDirected) {
            vertex2.addAdjacentVertex(edge,vertex1 );
        }
    }

    public void addVertex(Vertex<T> vertex) {
        if (allVertex.containsKey(vertex.getId())) {
            return;
        }

        allVertex.put(vertex.getId(),vertex );
        for (Edge<T> edge : vertex.getEdges()) {
            allEdges.add(edge);
        }
    }

    public Vertex<T> addSingleVertex(long id) {
        if (allVertex.containsKey(id)) {
            return allVertex.get(id);
        }

        Vertex<T> vertex = new Vertex<>(id);
        allVertex.put(id,vertex );
        return vertex;
    }

    public Vertex<T> getVertex(long id) {
        return allVertex.get(id);
    }

    public List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    public Collection<Vertex<T>> getAllVertex() {
        return allVertex.values();
    }

    public void setDataForVertex(long id, T data) {
        if (allVertex.get(id) != null) {
            Vertex<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Edge<T> edge : allEdges) {
            stringBuffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}


class Vertex<T> {
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void addAdjacentVertex(Edge<T> edge,  Vertex<T> vertex) {
        edges.add(edge);
        adjacentVertex.add(vertex);
    }

    public String toString() {
        return String.valueOf(id);
    }

    public List<Vertex<T>> getAdjacentVertexes() {
        return adjacentVertex;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public int getDegree() {
        return edges.size();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Vertex other = (Vertex)obj;
        if (id != other.id) return false;
        return true;
    }
}

class Edge<T> {
    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
        this.weight = weight;
    }

    Vertex<T> getVertex1() {
        return vertex1;
    }

    Vertex<T> getVertex2() {
        return vertex2;
    }

    int getWeight() {
        return weight;
    }

    boolean isDirected() {
        return isDirected;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (vertex1 == null ? 0 : vertex1.hashCode());
        result = prime * result + (vertex2 == null ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Edge other = (Edge)obj;
        if (vertex1 == null && other.vertex1 != null)
            return false;
        if (vertex2 == null && other.vertex2 != null)
            return false;
        if (!vertex1.equals(other.vertex1)) {
            return false;
        }
        if (!vertex2.equals(other.vertex2)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}