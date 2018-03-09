package com.algorithms.standard.graphs;

public class DFSandBFSGraphSearch {
    public static void main(String[] args) {
        OldGraph oldGraph = new OldGraph();

        oldGraph.addVertex('A');
        oldGraph.addVertex('B');
        oldGraph.addVertex('C');
        oldGraph.addVertex('D');
        oldGraph.addVertex('E');

        oldGraph.addEdge(0,1); //AB
        oldGraph.addEdge(1,2); //BC
        oldGraph.addEdge(0,3); //AD
        oldGraph.addEdge(3,4); //DE

        System.out.println("DFS Visits:\n");
        oldGraph.dfs();
        System.out.println();

        System.out.println("\nBFS Visits:\n");
        oldGraph.bfs();
        System.out.println();
    }
}

class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        st = new int[SIZE];
        top = -1;
    }

    public void push(int value) {
        st[++top] = value;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class Queue {
    private static final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int value) {
        if (rear == SIZE - 1) rear = -1;
        queArray[++rear] = value;
    }

    public int remove() {
        int temp = queArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front || front + SIZE - 1 == rear);
    }
}

class OldVertex<T> {
    public T label;
    public boolean wasVisited;

    public OldVertex(T label) {
        this.label = label;
    }
}

class OldGraph<T> {
    private final int MAX_VERTS = 20;
    private OldVertex<T> vertexList[];    // list of vertices
    private int adjMatrix[][];        // adjacency matrix
    private int nVerts;             // current number of vertices
    private StackX stack;           // Stack of vertex index
    private Queue queue;

    public OldGraph() {
        vertexList = new OldVertex[MAX_VERTS];
        nVerts = 0;

        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        stack = new StackX();
        queue = new Queue();
    }

    public OldVertex<T>[] getAllVertex() {
        return vertexList;
    }

    public void addVertex(char label) {
        vertexList[nVerts++] = new OldVertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int value) {
        System.out.println(vertexList[value].label);
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            // Get the next unvisited vertex adjacent to the current vertex
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1) {
                v = stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        } // end while

        resetVertexList();
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v2;

        while (!queue.isEmpty()) {
            int v1 = queue.remove();

            // Go through all the neighbors of the current vertex
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        } // end while

        resetVertexList();
    }

    private void resetVertexList() {
        for (int i = 0; i < nVerts; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVerts; i++) {
            if (adjMatrix[v][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }
        }
        return -1;
    }
}


