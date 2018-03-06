package furkanmetin;


public class Vertex {
    
    final private String id;
    final private String name;
//    public  String id;
//    public  String name;
    public double latitude;
    public double longitude;
    public int height;
    

    public Vertex(String id, String name, double latitude, double longitude,int height) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.height = height;
    }
    
    public Vertex(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name+" "+id+" "+latitude+" "+longitude+" "+height;
//         return name;
    }

}
