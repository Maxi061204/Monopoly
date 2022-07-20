
/**
 * Klasse Einkaufszentrum.
 *  
 * @author 
 */
public class Einkaufszentrum extends Feld {
    /*---------------Attribute-----*/
    int preis = 0;
    boolean verkauft = false;
    Spieler besitzer = null;
    Straße straße = null;
    int grundstücksID = 0;
    private final int basis_miete = 25;

    /*---------------Konstruktor---*/
    public Einkaufszentrum(Spiel spiel, String name, Straße straße, int id) {
        super(spiel, name);
        this.straße = straße;
        grundstücksID = id;
    }
    
    public void AktionAusfuehren(Spieler spieler){
        System.out.println("Du bist auf dem" +"Bahnhof gelandet" +"Zahle x&$ an spieler");
        if(spieler == null){
            if(spieler.buy(this)){
                besitzer = spieler;
                straße.gekauft(grundstücksID, spieler);
            }
        }
        else{
            spieler.zahlen(mieteBerechnen());
        }
        }

    /*---------------Methoden------*/    
    
    
    private int mieteBerechnen(){
        return 25 * pow(2, straße.count(besitzer) - 1);
    }
    /*
       25
       50
       100
       */
    
    private int pow(int basis, int exponent){
        if(exponent == 0){
            return 1;
        }
        return 2 * pow(basis, exponent -1);
    }
}
