/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        String[][] komsuluk = new String[kayit_say][];
        try{
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("C:\\Users\\Furkan\\Desktop\\komsu.txt"));
            String satir = reader.readLine();
            String[] blok;
            int i=0;
            while (satir!=null) {
                satir = reader.readLine();
                if(satir!=null){
                    blok = satir.split(",");
                    int sütun = blok.length;
                    
                    komsuluk[i]=new String[sütun];
                    for(int j=0;j<blok.length;j++){
                        komsuluk[i][j]=blok[j];
                    }
                i++;
                }
            }
        }catch(FileNotFoundException e){
            System.out.print("Dosya bulunamadi veya acilamadi.");
        }catch(IOException e){
            System.out.println("Dosya veri girdisinde hata olustu.");
        }
       
        Zeplin h = new Zeplin(5);
        System.out.println(h);
        
        for(int i=0;i<kayit_say;i++){
            int sütun=komsuluk[i].length;
            for(int j=1;j<sütun;j++){
                String deger = komsuluk[i][j];
                int indis=Integer.parseInt(deger);
                double uzunluk=calculateWeight(nodes.get(i),nodes.get(indis-1),nodes.get(34-1),nodes.get(1-1));
                int dgr = donustur(uzunluk);
                double derece=calculateSlope(nodes.get(i),nodes.get(indis-1),nodes.get(34-1),nodes.get(1-1),dgr);
                if(h.manevra>=derece){
                    addLane(i+"Edge"+indis, i, indis-1, dgr, derece);                  
                }
            }    
        }
//            for(Edge n: edges){
//                System.out.println(n.getId()+" "+n.weight);
//            }

        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(34-1));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(1-1));
        
        
        // Bağlı listenin null değer taşıyıp taşımadığını kontrol edip gerekli hesaplamalar yapılıyor...
        if(path==null){
            System.out.println("Belirlenen şehirler arasi Güzergah bulunamamistir.");
        }
        else{
            int k =0;
            double toplam=0;
            String[] id_bilgi = new String[boyut_hesapla(path)];
            // bağlı listenin içerisindeki nesneleri parse edip yol hesaplaması yapabilmek için gerekli işlemler 
            for (Vertex n : path) {
                id_bilgi[k]=n.getId();
//                System.out.println(id_bilgi[k]);
                 k++;
                System.out.print(n);
            }
            for(int e=0;e<id_bilgi.length-1;e++){
                int al_1 = Integer.parseInt(id_bilgi[e]);
                int al_2 = Integer.parseInt(id_bilgi[e+1]);
//                System.out.print(al_1+" "+al_2+"  ");
                double uz = calculateWeight(nodes.get(al_1-1),nodes.get(al_2-1),nodes.get(34-1),nodes.get(1-1)) ;
//                System.out.println(uz);
                toplam = toplam + uz;
            }
            System.out.println("\nToplam yol : "+ toplam);
            h.al_yol = toplam;
        }    
            System.out.println(h.al_yol);    
                    
                
                
            
        
        

    }   
    
    // Parametre olarak aldığı bağlı listenin boyutunu return eder...
    public static int boyut_hesapla(LinkedList<Vertex> vertexes){
        return vertexes.size();
    }
    public static void addLane(String laneId, int sourceLocNo, int destLocNo, int duration,double slope) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration , slope );
        edges.add(lane);
    }
   
    // Dosya yı okuyup içerisindeki mevcut satır sayısını return eder...
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
    
    // Mevcut iki şehirin latitude ve longitude değerlerine göre aralarındaki
    // mesafeyi hesaplıyor
     public static double calculateWeight(Vertex source,Vertex destination,Vertex start,Vertex finish){
        double weight ;
        double fark;
        double lat1 = source.latitude;
        double lat2 = destination.latitude;
        double lon1 = source.longitude;
        double lon2 = destination.longitude;
        
        double R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2-lat1);  // deg2rad below
        double dLon = deg2rad(lon2-lon1); 
        double a = 
            Math.sin(dLat/2) * Math.sin(dLat/2) +
            Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
            Math.sin(dLon/2) * Math.sin(dLon/2); 
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
            double d = R * c; // Distance in km
           
        if(source==start&&destination==finish) {
                fark = Math.abs(Math.abs(source.height-destination.height));
               fark = fark/1000;
                weight = Math.sqrt((fark*fark)+(d*d));
                return weight;
            }
            else if(source==start){
                fark = Math.abs((Math.abs(source.height-50-destination.height)));
                fark = fark/1000;
                weight = Math.sqrt((fark*fark)+(d*d));
                return weight;
            }
            else if(destination==finish){
                fark = Math.abs((Math.abs(source.height-destination.height+50)));
                fark = fark/1000;
                weight = Math.sqrt((fark*fark)+(d*d));
                return weight;
            }
            else{
                fark = Math.abs(Math.abs(source.height-destination.height));
                fark = fark/1000;
                weight = Math.sqrt((fark*fark)+(d*d));
               return weight;
            }
        
    }
    
    //Dereceyi radyana dönüştürür...
    public static double deg2rad(double deg) {
              return deg * (Math.PI/180);
    }
    
  //Bu fonksiyon iki şehir arasındaki eğimi hesaplıyor (extent = derece) (slope = derece)
    public static double calculateSlope(Vertex source,Vertex destination,Vertex start,Vertex finish,int dis){
            double extent; 
            double distance;
            distance = dis;
            distance = distance/10000;
            if(source==start&&destination==finish) {
                extent= Math.atan((Math.abs(source.height-destination.height))/distance);
                extent=extent*180/Math.PI;
                return extent;
            }
            else if(source==start){
                extent= Math.atan((Math.abs(source.height-50-destination.height))/distance);
                extent=extent*180/Math.PI;
                return extent;
            }
            else if(destination==finish){
                extent= Math.atan((Math.abs(source.height-destination.height+50))/distance);
                extent=extent*180/Math.PI;
                return extent;
            }
            else{
               extent= Math.atan((Math.abs(source.height-destination.height))/distance);
               extent=extent*180/Math.PI;
               return extent;
            }

    }
    
    // Parametre olarak aldığı double değişkeni integer a çevirir.
    public static int donustur(double deger){
        deger = deger * 10000;
        String m =Double.toString(deger);
        String[] a = m.split("[.]");
        int a_b = Integer.parseInt(a[0]);
        return a_b;
    }
}
