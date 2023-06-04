package PhoneNetworkApp;


import GraphFrameWork.Graph;
import GraphFrameWork.Kruskal;
import GraphFrameWork.MSTAlgorthim;
import GraphFrameWork.Prim;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNWDesignApp {

    // Define a Scanner object to read input from the user
    static Scanner input = new Scanner(System.in);

    // Define a Graph object with a maximum size of 999 vertices
    static Graph graph = new Graph(999);

    public static void main(String[] args) throws FileNotFoundException {

        // Print a menu of options for the user to select from
        System.out.println("Kruskal's Algorithm & Prim Algorithm to solve MST problem");
        System.out.println("Choose which requirement you want to run:");
        System.out.println("Enter 1 for Requirement 1 or Enter 2 for Requirement 2:");

        // Read the user's input and store it in a variable
        int input1 = input.nextInt();

        // If the user selected Requirement 1...
        if (input1 == 1) {

            // Print a menu of options for the user to select from
            System.out.println(">>> n is the number of vertices and m is the number of edges:");
            System.out.println(" 1: n=1,000, m=10,000");
            System.out.println(" 2: n=1,000, m=15,000");
            System.out.println(" 3: n=1,000, m=25,000");
            System.out.println(" 4: n=5,000, m=15,000");
            System.out.println(" 5: n=5,000, m=25,000");
            System.out.println(" 6: n=10,000, m=15,000");
            System.out.println(" 7: n=10,000, m=25,000");

            // Read the user's input and store it in a variable
            System.out.print(">>> Enter a case to test: ");
            int Case = input.nextInt();

            // Based on the user's input, call the graph method to create a graph with the specified number of vertices and edges
            switch (Case) {
                case 1:
                    graph(1000, 10000);
                    break;
                case 2:
                    graph(1000, 15000);
                    break;
                case 3:
                    graph(1000, 25000);
                    break;
                case 4:
                    graph(5000, 15000);
                    break;
                case 5:
                    graph(5000, 25000);
                    break;
                case 6:
                    graph(10000, 15000);
                    break;
                case 7:
                    graph(10000, 25000);
                    break;
                default:
                    System.out.println("---Invalid input!---");
                    break;
            }

            // Run Kruskal's and Prim's algorithms on the generated graph 10 times
            for (int n = 1; n < 11; n++) {
                System.out.println("--------------------------(" + n + ")----------------------------\n\nPrim MH Based Algorithm:");
                MSTAlgorthim alg2 = new Prim(graph);
                alg2.DisplyResultingMST(input1);
                System.out.println("-------------------------------------------------\nKruskal Algorithm:");
                MSTAlgorthim alg1 = new Kruskal(graph);
                alg1.DisplyResultingMST(input1);
            }

        } 
        
        // If the user selected Requirement 2...
        if (input1 == 2) {
            // Read a graph from a file and store it in a Graph object
            Graph graph = Graph.readGraphFromFile("input1.txt");

            // Run Prim's algorithm on the graph
            MSTAlgorthim alg2 = new Prim(graph);
            alg2.DisplyResultingMST(input1);

            // Print a separator
            System.out.println("\n-------------------------------------------------");

            // Run Kruskal's algorithm on the graph
            MSTAlgorthim alg1 = new Kruskal(graph);
            alg1.DisplyResultingMST(input1);
        }
    }

    // A helper method that creates a graph with the specified number of vertices and edges
    public static Graph graph(int vertices, int edges) throws FileNotFoundException {
        Graph graph = new Graph(vertices, edges, false);
        return graph.make_graph();
    }

}