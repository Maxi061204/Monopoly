
/**
 * Klasse Kraftwerk.
 *  
 * @author 
 */
public class Kraftwerk extends Feld {
    /*---------------Attribute-----*/
    private Spieler besitzer = null;
    private int index_in_straße = 0;
    private Straße straße = null;

    /*---------------Konstruktor---*/
    public Kraftwerk(Spiel spiel, String name, int id, Straße straße) {
        super(spiel, name);
        index_in_straße = id;
        this.straße = straße;
    }
    
    public void AktionAusfuehren(Spieler spieler){
        System.out.println("Du bist auf dem "+ name + " gelandet");
        if(besitzer == null){
            if(spieler.buy(this)){
                besitzer = spieler;
                straße.gekauft(index_in_straße, spieler);
            }
        }else{
            if(besitzer != spieler){
                spieler.zahlen(miete(spieler));
            }
        }
    }

    /*---------------Methoden------*/    

    private int miete(Spieler spieler){
        int c = straße.count(spieler);
        if(c == 1){
            return 4 * spieler.letzter_wurf;
        }
        return 10 * spieler.letzter_wurf;
    }
}
