package GraphFrameWork;

public class Edge implements Comparable<Edge> {

    int src; // an integer representing the source vertex of the edge
    int dest; // an integer representing the destination vertex of the edge
    int weight; // an integer representing the weight of the edge
    Vertex source; // a Vertex object representing the source vertex of the edge
    Vertex target; // a Vertex object representing the target vertex of the edge
    Vertex parent; // a Vertex object representing the parent vertex of the edge

    public Edge(int weight) {
        this.weight = weight;
    }

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.parent = source;
    }

    @Override
    public int compareTo(Edge other) {
        return weight - other.weight;
    } // compares edges based on their weight

    public String displyInfo() {
        return "line length " + weight;
    } // returns a string with information about the edge, in this case just the weight of the edge
}