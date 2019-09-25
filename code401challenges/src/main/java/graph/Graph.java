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

    // Add Undirected Edge
    public void addUndirectedEdge(Vertex<T> a, Vertex<T> b, int weight) {
        addDirectedEdge(a, b, weight);
        addDirectedEdge(b, a, weight);
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
    public ArrayList<Vertex<T>> breadthFirst(Vertex<T> node) {
        // Extend your graph object with a breadth-first traversal method that accepts a starting node
        // Without utilizing any of the built-in methods available to your language,
        // return a collection of nodes in the order they were visited. Display the collection

        ArrayList<Vertex<T>> result = new ArrayList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(node);
        node.visited = true;

        while (queue.peek() != null) {
            Vertex<T> v = queue.remove();
            result.add(v);

            List<Edge<T>> neighbors = getNeighbors(v);

            for (int i = 0; i < neighbors.size(); i++) {
                Vertex<T> vertexAtIndex = neighbors.get(i).vertex;

                if (vertexAtIndex != null && !vertexAtIndex.visited) {
                    queue.add(vertexAtIndex);
                    vertexAtIndex.visited = true;
                }
            }
        }

        return result;
    }

    public String directFlights(Graph<T> graph, Vertex<T>[] cities) {
        // Given a business trip itinerary, and an Alaska Airlines route map,
        // is the trip possible with direct flights?
        // If so, how much will the total trip cost be?
        // Write a function based on the specifications above, which takes in a graph, and an array of city names.
        // Return whether the full trip is possible with direct flights, and how much it would cost.

        for (Vertex<T> v : cities) {
            if (!graph.getNodes().contains(v)) {
                return  "false, $0";
            }
        }

        int cost = 0;
        boolean isFound = false;

        for (int i = 0; i < cities.length - 1; i++) {
            isFound = false;

            for (Edge<T> e : graph.getNeighbors(cities[i])) {

                if (e.vertex.value.equals(cities[i + 1].value)) {
                    cost += e.weight;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                // return -> boolean, cost
                return "false, $0";
            }
        }

        return isFound + ", $" + cost;
    }

    public ArrayList<T> depthFirst(Graph<T> graph, Vertex<T> node) {
        Stack<Vertex<T>> stack = new Stack<>();
        ArrayList<T> result = new ArrayList<>();

        if (node == null) {
            return null;
        } else {
            stack.push(node);
            node.visited = true;
        }

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();
            result.add(current.value);

            List<Edge<T>> neighbors = getNeighbors(current);

            for (int i = 0; i < neighbors.size(); i++) {
                Vertex<T> vertexAtIndex = neighbors.get(i).vertex;

                if (vertexAtIndex != null && !vertexAtIndex.visited) {
                    stack.push(vertexAtIndex);
                    vertexAtIndex.visited = true;
                }
            }
        }

        return result;
    }
}

