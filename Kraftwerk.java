
/**
 * Klasse Kraftwerk.
 *  
 * @author 
 */
public class Kraftwerk extends Feld {
    /*---------------Attribute-----*/
    private Spieler besitzer;
    private int index_in_straße;
    private int miete;
    private Straße straße;

    /*---------------Konstruktor---*/
    public Kraftwerk() {
        
    }
    
    public void AktionAusfuehren(Spieler spieler){
        System.out.println("Du bist auf dem "+ name + " gelandet");
        if(besitzer == null){
            if(spieler.buy(this)){
                besitzer = spieler;
                straße.gekauft(index_in_straße, spieler);
            }
        }
        if(besitzer != spieler){
            spieler.zahlen(miete());
        }
    }

    /*---------------Methoden------*/    

    private int miete(){
        return straße.count(besitzer) *  miete;
    }
}
