package unsw.graph;

import java.util.Iterator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstGraphIterator<N extends Comparable<N>> implements Iterator<N> {
    private Set<N> visited = new HashSet<>();
    private Stack<N> stack = new Stack<>();
    private Graph<N> graph;

    public DepthFirstGraphIterator(Graph<N> graph, N start) {
        this.graph = graph;
        this.stack.push(start);
        this.visited.add(start);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public N next() {
        N next = stack.pop();
        if (!visited.contains(next)) {
            this.visited.add(next);
        }
        for (N node : this.graph.getAdjacentNodes(next)) {
            if (!visited.contains(node)) {
                stack.push(node);
            }
        }
        return next;
    }
    
    // public void update() {
    //     Iterator<N> adjs = this.stack.peek();
    //     do {
    //         while (!adjs.hasNext()) {
    //             this.stack.pop();
    //             // done case
    //             if (this.stack.isEmpty()) {
    //                 this.next = null;
    //                 return;
    //             }
    //             adjs = this.stack.peek();
    //         }
    //         this.next = adjs.next();
    //     } while (this.visited.contains(this.next));
    //     this.stack.push(this.graph.getAdjacentNodes(this.next).iterator());
    // }
}
