package ds.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void dfs() {
        Graph graph = createGraph();

        assertEquals("[Bob, Rob, Maria, Alice, Mark]", graph.depthFirstTraversal("Bob").toString());
        assertEquals("[Mark, Rob, Maria, Alice, Bob]", graph.depthFirstTraversal("Mark").toString());
    }

    @Test
    void bfs() {
        Graph graph = createGraph();

        assertEquals("[Bob, Alice, Rob, Mark, Maria]", graph.breadthFirstTraversal("Bob").toString());
        assertEquals("[Mark, Alice, Rob, Bob, Maria]", graph.breadthFirstTraversal("Mark").toString());
    }

    private Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

}