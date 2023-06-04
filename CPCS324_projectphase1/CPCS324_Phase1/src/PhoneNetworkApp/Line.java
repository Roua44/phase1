package PhoneNetworkApp;

import GraphFrameWork.Edge;
import GraphFrameWork.Vertex;

public class Line extends Edge {
    // instance variables
    private String phoneNumber; // stores the phone number associated with the line
    private Vertex parentVertex; // stores the source vertex of the line
    Integer ILength;

    // constructors
    public Line(int weight) {
        super(weight);
    }

    public Line(int src, int dest, int weight) {
        super(src, dest, weight);
    }

    public Line(Vertex source, Vertex target, int weight) {
        super(source, target, weight); // calls the constructor of the Edge class
        this.parentVertex = source; // sets the parentVertex instance variable to the source parameter
    }

    // getter and setter methods
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Vertex getParentVertex() {
        return parentVertex;
    }

    public void setParentVertex(Vertex parentVertex) {
        this.parentVertex = parentVertex;
    }
}