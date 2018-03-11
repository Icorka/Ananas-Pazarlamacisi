/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furkanmetin;

public class Zeplin {
    int yolcu_sayisi;
    double manevra;
    double al_yol;
    
       Zeplin(int yolcu_sayisi){
           this.yolcu_sayisi = yolcu_sayisi;
           this.manevra = 80 - yolcu_sayisi;
       }
       
public String toString() {
        return "yolcu sayisi : "+yolcu_sayisi+" manevra : "+manevra;
//         return name;
    }
   // public int kar_hesabi(){
   //    return 0;
   // }
       
}
