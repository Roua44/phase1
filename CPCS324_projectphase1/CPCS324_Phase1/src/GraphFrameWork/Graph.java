package GraphFrameWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Graph {

    public int veticesNo; // No. of vertices
    public List<List<Vertex>> adj;
    int edgeNo;
    boolean isDigraph = false;
    public Vertex[] vetices;
    Graph graph;
    boolean isDigraoh;

    public Graph() {
    }

    public Graph(int V) {
        this.veticesNo = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public int getNoOfVertices() {
        return veticesNo;
    }

    public void addEdge(int u, int v, int w) {
        adj.get(u).add(new Vertex(v, w));
        adj.get(v).add(new Vertex(u, w));
    }

    public Vertex createVertex(int label) {
        return new Vertex(label);
    }

    public Graph(int veticesNo, int edgess, boolean isDigraph) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgess;
        this.isDigraph = isDigraph;
        this.vetices = new Vertex[veticesNo];
        for (int i = 0; i < veticesNo; i++) {
            vetices[i] = new Vertex(i);
        }
    }

    public void addEdge(Vertex source, Vertex target, int weight) {
        Edge edge = new Edge(source, target, weight);
        source.adjlist.addFirst(edge);
        if (!isDigraph) {
            edge = new Edge(target, source, weight);
            target.adjlist.addFirst(edge);
        }
    }

    public Graph make_graph() {
        // create a random object to generate random numbers
        Random random = new Random();
        // create a new graph object to return
        Graph graph = new Graph(veticesNo);
        
        // make sure all vertices are connected to each other
        for (int i = 1; i < veticesNo - 1; i++) {
            int RandomNum = random.nextInt(20) + 1;
            graph.addEdge(vetices[i], vetices[i + 1], RandomNum);
        }

        // add remaining edges to the graph
        int remaning = edgeNo - (veticesNo - 1);

        for (int i = 0; i < remaning; i++) {
            Vertex source = vetices[random.nextInt(veticesNo)];
            Vertex Destination = vetices[random.nextInt(veticesNo)];

            int weight = random.nextInt(20) + 1;
            // to avoid duplicate edges
            if (source == Destination || isConnected(source, Destination)) {
                i--;
            } else {
                // add edge to graph
                graph.addEdge(source, Destination, weight);
            }
        }
        return graph;
    }
    // check if the edge is exist and connect
    public boolean isConnected(Vertex Source, Vertex target) {
        for (Edge edge : Source.adjlist) {
            if (edge.target == target) {
                return true;
            }
        }
        return false;
    }

    public static Graph readGraphFromFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));

        String type = scanner.next();
        boolean isDigraph = true;
        if (scanner.nextInt() == 1) {
            isDigraph = false;
        }

        int numVertices = scanner.nextInt();
        int numEdges = scanner.nextInt();

        Graph graph = new Graph(numVertices);

        while (scanner.hasNext()) {
            String sourceLabel = scanner.next();
            String targetLabel = scanner.next();
            int weight = scanner.nextInt();

            int sourceIndex = sourceLabel.charAt(0) - 'A';
            int targetIndex = targetLabel.charAt(0) - 'A';

            graph.addEdge(sourceIndex, targetIndex, weight);
            if (!isDigraph) {
                graph.addEdge(targetIndex, sourceIndex, weight);
            }
        }

        scanner.close();

        return graph;
    }

}