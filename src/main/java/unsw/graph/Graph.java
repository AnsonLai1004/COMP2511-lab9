package unsw.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * A class that implements an undirected graph using a HashMap.
 * @param <N> Node type
 * The node type must implement the Comparable interface so we can sort a collection of nodes.
 * 
 * @author Nick Patrikeos
 */
public class Graph<N extends Comparable<N>> {
    
    private HashMap<N, List<N>> graph = new HashMap<N, List<N>>();

    /**
     * Adds the given node to the graph
     */
    public void addNode(N node) {
        graph.put(node, new ArrayList<N>());
    }

    /**
     * Adds an edge between node1 and node2.
     * @precondition node1 and node2 are nodes in the graph
     * @postcondition If there is already a connection present between the two nodes, does nothing.
     */
    public void addConnection(N node1, N node2) {
        List<N> node1Adjacencies = graph.get(node1);
        if (!node1Adjacencies.contains(node2)) {
            node1Adjacencies.add(node2);
            Collections.sort(node1Adjacencies);
            
            graph.get(node2).add(node1);
            Collections.sort(graph.get(node2));
        }
    }

    /**
     * Retrieves all the nodes adjacent to the given node.
     * @precondition node is in the graph
     */
    public List<N> getAdjacentNodes(N node) {
        List<N> adjacencies = new ArrayList<N>(graph.get(node));                                          
        return adjacencies;
    }

    public BreadthFirstGraphIterator<N> breadthFirstIterator(N start) {
        return new BreadthFirstGraphIterator<N>(this, start);
    }

    public DepthFirstGraphIterator<N> depthFirstIterator(N start) {
        return new DepthFirstGraphIterator<N>(this, start);
    }
}