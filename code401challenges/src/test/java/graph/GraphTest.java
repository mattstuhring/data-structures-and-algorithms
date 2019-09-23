package graph;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GraphTest {
    /*
        - Node can be successfully added to the graph
        - An edge can be successfully added to the graph
        - A collection of all nodes can be properly retrieved from the graph
        - All appropriate neighbors can be retrieved from the graph
        - Neighbors are returned with the weight between nodes included
        - The proper size is returned, representing the number of nodes in the graph
        - A graph with only one node and edge can be properly returned
        - An empty graph properly returns null
     */

    @Test
    public void testAddNode_singleVertex() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v = graph.addNode("matt");

        assertTrue(graph.adjacencyList.containsKey(v));
    }

    @Test
    public void testAddNode_multipleVertex() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");
        Vertex<String> v3 = graph.addNode("ty");

        assertTrue(graph.adjacencyList.containsKey(v1));
        assertTrue(graph.adjacencyList.containsKey(v2));
        assertTrue(graph.adjacencyList.containsKey(v3));
    }

    @Test
    public void testAddNode_vertexDoesNotExist() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = new Vertex<>("bob");

        assertFalse(graph.adjacencyList.containsKey(v2));
    }

    @Test
    public void testAddDirectedEdge() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");

        graph.addDirectedEdge(v1, v2, 10);

        assertEquals(10, graph.adjacencyList.get(v1).get(0).weight);
    }

    @Test
    public void testGetNodes() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");

        assertTrue(graph.getNodes().contains(v1));
        assertTrue(graph.getNodes().contains(v2));
    }

    @Test
    public void testGetNeighbors() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");
        Vertex<String> v3 = graph.addNode("ty");

        graph.addDirectedEdge(v1, v2, 10);
        graph.addDirectedEdge(v1, v3, 20);

        assertEquals("kyso", graph.getNeighbors(v1).get(0).vertex.value);
        assertEquals("ty", graph.getNeighbors(v1).get(1).vertex.value);
    }

    @Test
    public void testSize() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");

        assertEquals(2, graph.size);
    }

    @Test
    public void testEmptyGraph() {
        Graph<String> graph = new Graph<>();

        assertEquals(0, graph.size);
    }
}