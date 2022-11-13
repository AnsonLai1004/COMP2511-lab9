package unsw.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstGraphIterator<N extends Comparable<N>> implements Iterator<N> {
    private Set<N> visited = new HashSet<>();
    private Queue<N> queue = new LinkedList<>();
    private Graph<N> graph;
    

    public BreadthFirstGraphIterator(Graph<N> graph, N start) {
        this.graph = graph;
        this.queue.add(start);
        this.visited.add(start);
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public N next() {
        N next = queue.remove();
        visited.add(next);
        for (N adj : this.graph.getAdjacentNodes(next)) {
            if (!this.visited.contains(adj)) {
                this.queue.add(adj);
                this.visited.add(adj);
            }
        }
        return next;
    }

}
