package furkanmetin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FurkanMetin {
    
    private static List<Vertex> nodes;
    private static List<Edge> edges;
    static String bas_id;
    static String bit_id;

    public static void main(String[] args)
    {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        int kayit_say = dosya_satir_say();
        Vertex[] sehir = new Vertex[kayit_say];
        String kayit ;
        try{
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("C:\\Users\\Furkan\\Desktop\\lat long1.txt"));
            String satir = reader.readLine();
            
            int i=0;
            while (satir!=null) {
                satir = reader.readLine();
                if(satir!=null){
                    String[] blok;
                
                blok = satir.split(",");
                String isim = blok[0];
                double en = Double.parseDouble(blok[1]);
                double boy = Double.parseDouble(blok[2]);
                String plk = blok[3];
                int yuk = Integer.parseInt(blok[4]);
//                System.out.println(isim+" "+en+" "+boy+" "+plk+" "+yuk+" ");
                  sehir[i] = new Vertex(plk,isim,en,boy,yuk);
                nodes.add(sehir[i]);
                i++;
                
                }
            }
        }catch(FileNotFoundException e){
            System.out.print("Dosya bulunamadi veya acilamadi.");
        }catch(IOException e){
            System.out.println("Dosya veri girdisinde hata olustu.");
        }
    
//        for(Vertex n : sehir){
//            System.out.println(n);
//        }
        String[] komsuluk ;
        try{
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("C:\\Users\\Furkan\\Desktop\\komsu.txt"));
            String satir = reader.readLine();
            
            int i=0;
            while (satir!=null) {
                satir = reader.readLine();
                String[] blok;
                if(satir!=null){
                
                blok = satir.split(",");
//                    System.out.println((i+1)+" . satir : "+blok.length);
//                for(int j=0;i<blok.length;j++){
//                    
//                }
                System.out.println(satir);
//                System.out.println(isim+" "+en+" "+boy+" "+plk+" "+yuk+" ");
                  
                
                i++;
                
                }
            }
        }catch(FileNotFoundException e){
            System.out.print("Dosya bulunamadi veya acilamadi.");
        }catch(IOException e){
            System.out.println("Dosya veri girdisinde hata olustu.");
        }
//        nodes = new ArrayList<Vertex>();
//        edges = new ArrayList<Edge>();
//        for (int i = 0; i < 11; i++) {
//            Vertex location = new Vertex("Node_" + i, "Node_" + i);
//            nodes.add(location);
//        }
//        addLane("Edge_0", 0, 1, 85);
//        addLane("Edge_1", 1, 0, 85);
//        addLane("Edge_2", 0, 2, 217);
//        addLane("Edge_3", 2, 0, 217);
//        addLane("Edge_4", 0, 4, 173);
//        addLane("Edge_5", 4, 0, 173);
//        addLane("Edge_6", 2, 6, 186);
//        addLane("Edge_7", 6, 2, 186);
//        addLane("Edge_8", 2, 7, 103);
//        addLane("Edge_9", 7, 2, 103);
//        addLane("Edge_10", 3, 7, 183);
//        addLane("Edge_11", 7, 3, 183);
//        addLane("Edge_12", 5, 8, 250);
//        addLane("Edge_13", 8, 5, 250);
//        addLane("Edge_14", 8, 9, 84);
//        addLane("Edge_15", 9, 8, 84);
//        addLane("Edge_16", 7, 9, 167);
//        addLane("Edge_17", 9, 7, 167);
//        addLane("Edge_18", 4, 9, 502);
//        addLane("Edge_19", 9, 4, 502);
//        addLane("Edge_20", 9, 10, 40);
//        addLane("Edge_21", 10, 9, 40);
//        addLane("Edge_22", 1, 10, 600);
//        addLane("Edge_23", 10, 1, 600);
//
//        // Lets check from location Loc_1 to Loc_10
//        Graph graph = new Graph(nodes, edges);
//        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
//        dijkstra.execute(nodes.get(0));
//        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(5));
//
//        
//        for (Vertex vertex : path) {
//            System.out.println(vertex);
//        }
//        
// 
//    }  
//
//    
//    private static void addLane(String laneId, int sourceLocNo, int destLocNo,int duration) {
//        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
//        edges.add(lane);
//    }
    }
    private static int dosya_satir_say(){
         int lineNumber = 0;
         try
         {
         BufferedReader reader = null;
         reader = new BufferedReader(new FileReader("C:\\Users\\Furkan\\Desktop\\lat long1.txt"));
         String satir = reader.readLine();
            satir = reader.readLine();
             while (satir!=null) {
              if(satir.length()>0){
               lineNumber++;
              }
              satir = reader.readLine();                
             }    
         }catch(final IOException e){}
         return lineNumber;
     
    }
    
  
}
