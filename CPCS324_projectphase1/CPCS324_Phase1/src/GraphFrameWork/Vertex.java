package GraphFrameWork;

import java.util.LinkedList;

public class Vertex {

    public int Node, Key; // node number and key value
    public int label; // vertex label
    public Boolean isVisited; // whether the vertex has been visited or not
    public int dest; // destination vertex number
    public int weight; // weight of the edge
    LinkedList<Edge> adjlist; // adjacency list of the vertex

    public Vertex(int label) {
        this.label = label; // initialize vertex label
        adjlist = new LinkedList<>(); // initialize adjacency list
    }

    public Vertex() {
        this.Node = Node;
        this.Key = Key;
        this.label = label;
        this.isVisited = isVisited;
    }

    public Vertex(int Node, int Key, int q) {
        this.Node = Node;
        this.Key = Key;
    }

    public Vertex(int dest, int weight) {
        this.dest = dest; // initialize destination vertex number
        this.weight = weight; // initialize edge weight
    }

    public int getDest() {
        return dest; // return destination vertex number
    }

    public int getWeight() {
        return weight; // return edge weight
    }

    public String displyInfo(int vertexNumber) {
        return "Office No." + (char) (vertexNumber + 'A'); // display the vertex number as a character
    }

}