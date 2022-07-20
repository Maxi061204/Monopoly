
/**
 * Klasse Zusatzsteuer.
 *  
 * @author 
 */
public class Zusatzsteuer extends Feld {
    /*---------------Attribute-----*/

    /*---------------Konstruktor---*/
    public Zusatzsteuer() {
    }

    public void AktionAusfuehren(Spieler spieler){

        spieler.zahlen(100);
        spiel.in_frei_parken_zahlen(100);
        System.out.println("Du bist auf Zusatzsteuer gelandet. Zahle 100$");
    }
    /*---------------Methoden------*/    
}
