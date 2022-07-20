
/**
 * Klasse DiceD6.
 *  
 * @author 
 */
import java.util.Random;

public class DiceD6 {
    /*---------------Attribute-----*/
    int ergebnisse[];
    
    /*---------------Konstruktor---*/
    public DiceD6() {
    ergebnisse = new int [2]; 
     
    }

    /*---------------Methoden------*/    

    public void wuerfeln(){
     int n = (int)(Math.random()*6 + 1);
     int m = (int)(Math.random()*6 + 1);
     ergebnisse[0]=n;
     ergebnisse[1]=m;
    
     
     
     
    }
    
    private boolean pasch(int wuerfel1, int wuerfel2){
        return wuerfel1 == wuerfel2;
    }
    
}
