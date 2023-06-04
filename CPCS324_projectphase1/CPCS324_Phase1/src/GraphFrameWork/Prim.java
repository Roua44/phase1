package GraphFrameWork;

import java.util.*;

public class Prim extends MSTAlgorthim {

    private int[] parent; // array to store the parent of each vertex in the MST
    double startTime = 0;
    double finishTime = 0;

    public Prim(Graph g) {
        super(g);
        this.parent = new int[V];
    }

    // Print MST using Prim's algorithm
    @Override
    public void DisplyResultingMST(int choice) {

        startTime = System.nanoTime();

        PriorityQueue<Vertex> pq = new PriorityQueue<>(V, new Comparator<Vertex>() {
            public int compare(Vertex a, Vertex b) {
                return a.Key - b.Key;
            }
        });

        int src = 0; // Taking vertex 0 as source

        int INF = Integer.MAX_VALUE;
        int[] key = new int[V];
        Arrays.fill(key, INF);

        Arrays.fill(parent, -1);

        boolean[] inMST = new boolean[V];

        pq.offer(new Vertex(0, src));
        key[src] = 0;

        while (!pq.isEmpty()) {
            int target = pq.peek().Node;
            pq.poll();

            if (target < 0 || target >= V || inMST[target]) {
                continue;
            }

            inMST[target] = true;

            List<Vertex> adjList = adj.get(target);
            for (Vertex adjVertex : adjList) {
                int v = adjVertex.getDest();
                int weight = adjVertex.getWeight();

                if (v < 0 || v >= V || inMST[v] || key[v] <= weight) {
                    continue;
                }

                key[v] = weight;
                pq.offer(new Vertex(key[v], v, 1));
                parent[v] = target;
            }
        }

        if (choice == 2) {
            int minCost = 0, x = 0;
            Vertex vertex = new Vertex();
            System.out.println("The phone network (minimum spanning tree) generated by min-heap based Prim algorithm \n"
                    + "is as follows: ");
            for (int i = 1; i < V; i++) {
                Edge currentEdge = new Edge(key[i]);
                System.out.println(vertex.displyInfo(parent[i] + x) + " - " + vertex.displyInfo(currentEdge.dest + i) + " : " + currentEdge.displyInfo());

                minCost += key[i];
                x++;
            }
            System.out.println("The cost of designed phone network: " + minCost);
        }

        finishTime = System.nanoTime();
        double totalTime = (finishTime - startTime) / 10000;
        if (choice == 1) {
            System.out.print("Runtime (in Milliseconds) : " + totalTime + "\n");
        }
    }
}
