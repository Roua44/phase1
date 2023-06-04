package GraphFrameWork;

import java.util.List;

public abstract class MSTAlgorthim {

    protected int V; // number of vertices
    protected List<List<Vertex>> adj; // adjacency list of the graph

    public MSTAlgorthim(Graph g) {
        this.V = g.veticesNo; // set the number of vertices
        this.adj = g.adj; // set the adjacency list
    }

    // abstract method to compute the MST
    public abstract void DisplyResultingMST(int choice);
}