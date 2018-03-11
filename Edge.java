/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furkanmetin;

/**
 *
 * @author Furkan
 */
public class Edge {
   
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    public  int weight;
    public double slope;

    public Edge(String id, Vertex source, Vertex destination, int weight, double slope) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.slope = slope;
    }
    
    public Edge(String id, Vertex source, Vertex destination) {
        this.id = id;
        this.source = source;
        this.destination = destination;

    }

    public String getId() {
        return id;
    }
    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }
    public int getWeight() {
       return weight;
    }
   
    @Override
    public String toString() {
        return weight+"   "+slope+"   "+source + "           " + destination;
    }
    
}
