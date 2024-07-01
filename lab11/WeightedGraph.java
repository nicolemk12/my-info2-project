package lab11;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedGraph {
    private ArrayList<Node> nodes;
    private HashMap<String,String> stationen;
    private Node start;

    public WeightedGraph(ArrayList<Node> nodes, Node start) {
        this.nodes = nodes;
        this.start = start;
    }

    public WeightedGraph() {
        BVGMapReader bvg = new BVGMapReader();
        nodes = bvg.readNodes("./bvg.txt");
        stationen = bvg.readStations("./stations.txt");

    }

    public void shortestPath(Node ziel){
        while(!nodes.isEmpty()){

        }
    }

    public void shortestPath(Node start, Node ziel){

    }

    public void cheapestPath(Node ziel){

    }

    public void cheapestPath(Node start, Node ziel){

    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }
}
