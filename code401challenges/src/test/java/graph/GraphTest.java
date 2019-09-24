package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testBreadthFirst_attempt1() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");

        graph.addDirectedEdge(v1, v2, 10);
        graph.addDirectedEdge(v2, v1, 10);

        StringBuilder sb = new StringBuilder();

        for (Vertex<String> v : graph.breadthFirst(v1)) {
            sb.append(v.value).append(", ");
        }

        System.out.println(sb.toString());

        assertEquals("matt, kyso, ", sb.toString());
    }

    @Test
    public void testBreadthFirst_attempt2() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");
        Vertex<String> v3 = graph.addNode("ty");
        Vertex<String> v4 = graph.addNode("chica");
        Vertex<String> v5 = graph.addNode("mako");
        Vertex<String> v6 = graph.addNode("grace");

        graph.addDirectedEdge(v1, v2, 10);
        graph.addDirectedEdge(v1, v3, 10);
        graph.addDirectedEdge(v2, v4, 10);
        graph.addDirectedEdge(v2, v5, 10);
        graph.addDirectedEdge(v3, v6, 10);

        StringBuilder sb = new StringBuilder();

        for (Vertex<String> v : graph.breadthFirst(v1)) {
            sb.append(v.value).append(", ");
        }

        assertEquals("matt, kyso, ty, chica, mako, grace, ", sb.toString());
    }

    @Test
    public void testBreadthFirst_attempt3() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("matt");
        Vertex<String> v2 = graph.addNode("kyso");
        Vertex<String> v3 = graph.addNode("ty");
        Vertex<String> v4 = graph.addNode("chica");
        Vertex<String> v5 = graph.addNode("mako");
        Vertex<String> v6 = graph.addNode("grace");

        graph.addDirectedEdge(v2, v6, 10);
        graph.addDirectedEdge(v4, v3, 10);
        graph.addDirectedEdge(v1, v4, 10);
        graph.addDirectedEdge(v3, v5, 10);
        graph.addDirectedEdge(v5, v6, 10);
        graph.addDirectedEdge(v6, v2, 10);

        StringBuilder sb = new StringBuilder();

        for (Vertex<String> v : graph.breadthFirst(v1)) {
            sb.append(v.value).append(", ");
        }

        assertEquals("matt, chica, ty, mako, grace, kyso, ", sb.toString());
    }

    @Test
    public void testBreadthFirst_attempt4() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("Pandora");
        Vertex<String> v2 = graph.addNode("Arendelle");
        Vertex<String> v3 = graph.addNode("Metroville");
        Vertex<String> v4 = graph.addNode("Monstroplolis");
        Vertex<String> v5 = graph.addNode("Narnia");
        Vertex<String> v6 = graph.addNode("Naboo");

        graph.addUndirectedEdge(v1, v2, 10);
        graph.addUndirectedEdge(v2, v3, 10);
        graph.addUndirectedEdge(v2, v4, 10);
        graph.addUndirectedEdge(v3, v4, 10);
        graph.addUndirectedEdge(v3, v5, 10);
        graph.addUndirectedEdge(v3, v6, 10);
        graph.addUndirectedEdge(v4, v6, 10);

        StringBuilder sb = new StringBuilder();

        for (Vertex<String> v : graph.breadthFirst(v1)) {
            sb.append(v.value).append(", ");
        }

        assertEquals("Pandora, Arendelle, Metroville, Monstroplolis, Narnia, Naboo, ", sb.toString());
    }

    @Test
    public void testDirectFlights() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("Pandora");
        Vertex<String> v2 = graph.addNode("Arendelle");
        Vertex<String> v3 = graph.addNode("Metroville");
        Vertex<String> v4 = graph.addNode("Monstroplolis");
        Vertex<String> v5 = graph.addNode("Narnia");
        Vertex<String> v6 = graph.addNode("Naboo");

        graph.addUndirectedEdge(v1, v3, 82);
        graph.addUndirectedEdge(v1, v2, 150);
        graph.addUndirectedEdge(v2, v3, 99);
        graph.addUndirectedEdge(v2, v4, 42);
        graph.addUndirectedEdge(v3, v4, 105);
        graph.addUndirectedEdge(v3, v5, 37);
        graph.addUndirectedEdge(v3, v6, 26);
        graph.addUndirectedEdge(v4, v6, 73);
        graph.addUndirectedEdge(v5, v6, 250);

        Vertex[] cities = new Vertex[]{ v2, v3 };

        assertEquals("true, $99", graph.directFlights(graph, cities));
    }

    @Test
    public void testDirectFlights_attempt2() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("Pandora");
        Vertex<String> v2 = graph.addNode("Arendelle");
        Vertex<String> v3 = graph.addNode("Metroville");
        Vertex<String> v4 = graph.addNode("Monstroplolis");
        Vertex<String> v5 = graph.addNode("Narnia");
        Vertex<String> v6 = graph.addNode("Naboo");

        graph.addUndirectedEdge(v1, v3, 82);
        graph.addUndirectedEdge(v1, v2, 150);
        graph.addUndirectedEdge(v2, v3, 99);
        graph.addUndirectedEdge(v2, v4, 42);
        graph.addUndirectedEdge(v3, v4, 105);
        graph.addUndirectedEdge(v3, v5, 37);
        graph.addUndirectedEdge(v3, v6, 26);
        graph.addUndirectedEdge(v4, v6, 73);
        graph.addUndirectedEdge(v5, v6, 250);

        Vertex[] cities = new Vertex[]{ v3, v3 };

        assertEquals("false, $0", graph.directFlights(graph, cities));
    }

    @Test
    public void testDirectFlights_attempt3() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("Pandora");
        Vertex<String> v2 = graph.addNode("Arendelle");
        Vertex<String> v3 = graph.addNode("Metroville");
        Vertex<String> v4 = graph.addNode("Monstroplolis");
        Vertex<String> v5 = graph.addNode("Narnia");
        Vertex<String> v6 = graph.addNode("Naboo");

        graph.addUndirectedEdge(v1, v3, 82);
        graph.addUndirectedEdge(v1, v2, 150);
        graph.addUndirectedEdge(v2, v3, 99);
        graph.addUndirectedEdge(v2, v4, 42);
        graph.addUndirectedEdge(v3, v4, 105);
        graph.addUndirectedEdge(v3, v5, 37);
        graph.addUndirectedEdge(v3, v6, 26);
        graph.addUndirectedEdge(v4, v6, 73);
        graph.addUndirectedEdge(v5, v6, 250);

        Vertex[] cities = new Vertex[]{ v1, v2, v3, v4 };

        assertEquals("true, $354", graph.directFlights(graph, cities));
    }

    @Test
    public void testDirectFlights_attempt4() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("Pandora");
        Vertex<String> v2 = graph.addNode("Arendelle");
        Vertex<String> v3 = graph.addNode("Metroville");
        Vertex<String> v4 = graph.addNode("Monstroplolis");
        Vertex<String> v5 = graph.addNode("Narnia");
        Vertex<String> v6 = graph.addNode("Naboo");

        Vertex<String> doesNotExist = new Vertex<>("matt");

        graph.addUndirectedEdge(v1, v3, 82);
        graph.addUndirectedEdge(v1, v2, 150);
        graph.addUndirectedEdge(v2, v3, 99);
        graph.addUndirectedEdge(v2, v4, 42);
        graph.addUndirectedEdge(v3, v4, 105);
        graph.addUndirectedEdge(v3, v5, 37);
        graph.addUndirectedEdge(v3, v6, 26);
        graph.addUndirectedEdge(v4, v6, 73);
        graph.addUndirectedEdge(v5, v6, 250);

        Vertex[] cities = new Vertex[]{ v1, v2, v3, v4, doesNotExist };

        assertEquals("false, $0", graph.directFlights(graph, cities));
    }

    @Test
    public void testDirectFlights_attempt5() {
        Graph<String> graph = new Graph<>();
        Vertex<String> v1 = graph.addNode("Pandora");
        Vertex<String> v2 = graph.addNode("Arendelle");
        Vertex<String> v3 = graph.addNode("Metroville");
        Vertex<String> v4 = graph.addNode("Monstroplolis");
        Vertex<String> v5 = graph.addNode("Narnia");
        Vertex<String> v6 = graph.addNode("Naboo");

        Vertex<String> doesNotExist = new Vertex<>("matt");

        graph.addUndirectedEdge(v1, v3, 82);
        graph.addUndirectedEdge(v1, v2, 150);
        graph.addUndirectedEdge(v2, v3, 99);
        graph.addUndirectedEdge(v2, v4, 42);
        graph.addUndirectedEdge(v3, v4, 105);
        graph.addUndirectedEdge(v3, v5, 37);
        graph.addUndirectedEdge(v3, v6, 26);
        graph.addUndirectedEdge(v4, v6, 73);
        graph.addUndirectedEdge(v5, v6, 250);

        Vertex[] cities = new Vertex[]{ v1 };

        assertEquals("false, $0", graph.directFlights(graph, cities));
    }


}