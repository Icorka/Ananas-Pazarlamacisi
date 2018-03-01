public class sehir {
    int plaka;
    double enlem;
    double boylam;
    int yükseklik;
    sehir(){
        
    }
    sehir(int plaka,double enlem,double boylam,int yükseklik){
        this.plaka = plaka;
        this.enlem = enlem;
        this.boylam = boylam;
        this.yükseklik = yükseklik;
    }
    public String toString(){
        return "enlem :"+enlem+"boylam :"+boylam+"plaka :"+plaka+"yükseklik :"+yükseklik;
}
    
}
