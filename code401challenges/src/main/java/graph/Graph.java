package graph;

import java.util.*;

public class Graph<T> {

    public HashMap<Vertex<T>, List<Edge<T>>> adjacencyList;
    public int size = 0;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Adds a new node (vertex)
    public Vertex<T> addNode(T value) {
        Vertex<T> node = new Vertex<>(value);
        adjacencyList.put(node, new ArrayList<>());
        size++;
        return node;
    }

    // Add Directed Edge
    // Adds a directed edge between two vertices in a graph
    // Adds a new edge between two nodes in the graph
    // Include the ability to have a “weight”
    // Takes in the two nodes to be connected by the edge
    // Both nodes should already be in the Graph
    public void addDirectedEdge(Vertex<T> a, Vertex<T> b, int weight) {
        Edge<T> edge = new Edge<>(weight, b);
        adjacencyList.get(a).add(edge);
    }

    // Get Nodes
    // Returns all of the nodes (vertex) in the graph as a collection (set, list, or similar)
    public List<Vertex<T>> getNodes() {
        List<Vertex<T>> vertices = new ArrayList<>();

        for (Vertex<T> vertex : adjacencyList.keySet()) {
            vertices.add(vertex);
        }

        return vertices;
    }

    // Get Neighbors
    // Returns a collection of nodes (vertex) connected to the given node
    // Takes in a given node (vertex)
    // Include the weight of the connection in the returned collection
    public List<Edge<T>> getNeighbors(Vertex<T> vertex) {
        return adjacencyList.get(vertex);
    }

    // Get size
    // Returns the total number of nodes (vertex) in the graph
    public int size() {
        return this.size;
    }

    // BreadthFirst
    public List<Vertex<T>> BreadthFirst(Vertex<T> root) {
        // if there are children of the node we are currently looking at,
        // we want to mark each one as “visited”. By marking each child node as visited,
        // this will help us know that we have already seen that node before,
        // and won’t accidently push us into an infinite loop if the graph was cyclic.
        // In addition to marking each child node as visited, we want to place any of its children that have not yet been visited into the queue.

        return null;
    }

}

