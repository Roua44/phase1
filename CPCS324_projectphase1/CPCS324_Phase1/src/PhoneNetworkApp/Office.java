
import GraphFrameWork.Vertex;

public class Office extends Vertex {
    // instance variable
    private String officeName; // stores the name of the office

    // constructors
    public Office(int label) {
        super(label); // calls the constructor of the Vertex class with the label parameter
    }

    public Office(int Node, int Key, int q) {
        super(Node, Key, q); // calls the constructor of the Vertex class with the Node, Key, and q parameters
    }

    public Office(int dest, int weight) {
        super(dest, weight); // calls the constructor of the Vertex class with the dest and weight parameters
    }

    // getter and setter methods
    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    // method to display information about the office
    public String displayInfo(int vertexNumber) {
        return "Office No." + (char) (vertexNumber + 'A') + ", Name: " + officeName;
        // creates and returns a string in the format "Office No.A, Name: officeName"
        // where 'A' is added to the vertex number to create a letter identifier for the office
    }
}