
/**
 * Klasse Einkommenssteuer.
 *  
 * @author 
 */
public class Einkommenssteuer extends Feld {
    /*---------------Attribute-----*/

    /*---------------Konstruktor---*/
    public Einkommenssteuer(Spiel spiel, String name) {
        super(spiel, name);
    }

    public void AktionAusfuehren(Spieler spieler){
        spieler.zahlen(200);
        spiel.in_frei_parken_zahlen(200);
        System.out.println("Du musst deine Steuern in höhe von 200$ zahlen");
    }
    /*---------------Methoden------*/    

    
}
