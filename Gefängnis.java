
/**
 * Klasse Gefägnis.
 *  
 * @author 
 */
public class Gefängnis extends Feld {
    /*---------------Attribute-----*/


    /*---------------Konstruktor---*/
    public Gefängnis() {
    }
     public void AktionAusfuehren(Spieler spieler){
        spiel.send_to_prison(spieler);
        System.out.println("Gehe ins Gefägnis. Begib dich direkt dort Hin.Gehe nicht über los und ziehe nicht 200$ ein");
    }

    /*---------------Methoden------*/    

    
    
}
