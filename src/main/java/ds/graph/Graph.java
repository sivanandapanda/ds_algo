package ds.graph;

import java.util.*;

public class Graph {

    private final Map<Vertex, List<Vertex>> adjVertices = new HashMap<>();

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        var vertex = new Vertex(label);
        adjVertices.values().forEach(e -> e.remove(vertex));
        adjVertices.remove(vertex);
    }

    void addEdge(String label1, String label2) {
        var v1 = new Vertex(label1);
        var v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        var v1 = new Vertex(label1);
        var v2 = new Vertex(label2);
        var v1Edges = adjVertices.get(v1);
        var v2Edges = adjVertices.get(v2);

        if(v1Edges != null) v1Edges.remove(v2);
        if(v2Edges != null) v2Edges.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }

    Set<String> depthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var vertex = stack.pop();

            if(!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex adjVertex : getAdjVertices(vertex)) {
                    stack.push(adjVertex.label);
                }
            }
        }

        return visited;
    }

    Set<String> breadthFirstTraversal(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while(!queue.isEmpty()) {
            var vertex = queue.poll();
            for (Vertex adjVertex : getAdjVertices(vertex)) {
                if(!visited.contains(adjVertex.label)) {
                    visited.add(adjVertex.label);
                    queue.add(adjVertex.label);
                }
            }
        }

        return visited;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjVertices=" + adjVertices +
                '}';
    }
}
