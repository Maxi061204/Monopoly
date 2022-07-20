
/**
 * Klasse Frei_Parken.
 *  
 * @author 
 */
public class Frei_Parken extends Feld {
    /*---------------Attribute-----*/

    /*---------------Konstruktor---*/
    public Frei_Parken() {
    }
    public void AktionAusfuehren(Spieler spieler){
        spiel.frei_parken(spieler);
        System.out.println("Du bist auf Frei parken gelandet hier passiert nichts");
    }
    
    
    /*---------------Methoden------*/    

    //
    
}
