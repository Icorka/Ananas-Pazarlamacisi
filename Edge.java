package furkanmetin;


public class Edge {
   
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private  int weight;
    public double egim;

    public Edge(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        
    }
    
    public Edge(String id, Vertex source, Vertex destination) {
        this.id = id;
        this.source = source;
        this.destination = destination;
//        this.weight = calculateWeight(source,destination);
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
    public double calculateWeight(Vertex source,Vertex destination){
        double weight ;
        double lat1 = source.latitude;
        double lat2 = destination.latitude;
        double lon1 = source.longitude;
        double lon2 = destination.longitude;
        double theta = lon1 - lon2;
	double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	dist = Math.acos(dist);
	dist = rad2deg(dist);
	dist = dist * 60 * 1.1515;
	dist = dist * 1.609344;
		

		
        return dist;
    }


    @Override
    public String toString() {
        return source + " " + destination;
    }
    private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
    }
    private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
    }

}
