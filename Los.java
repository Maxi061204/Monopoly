
/**
 * Klasse Los.
 *  
 * @author 
 */
public class Los extends Feld {
    /*---------------Attribute-----*/


    /*---------------Konstruktor---*/
    public Los(String name, Spiel spiel) {
        super(spiel, name);
    }
    public void AktionAusfuehren(Spieler spieler){
        spieler.geld_geben(200);
        System.out.println("Du gehst über los. Ziehe 200$ ein ");
    }

    /*---------------Methoden------*/    

    
    
}
