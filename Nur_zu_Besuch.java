
/**
 * Klasse Nur_zuBesuch.
 *  
 * @author 
 */
public class Nur_zu_Besuch extends Feld {
    /*---------------Attribute-----*/


    /*---------------Konstruktor---*/
    public Nur_zu_Besuch(Spiel spiel, String name) {
        super(spiel, name);
    }
    public void AktionAusfuehren(Spieler spieler){
        System.out.println("Du bist nur zu besuch. Dir passiert nichts");
    }
    /*---------------Methoden------*/    

    
    
}
