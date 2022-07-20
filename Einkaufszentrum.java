
/**
 * Klasse Einkaufszentrum.
 *  
 * @author 
 */
public class Einkaufszentrum extends Feld {
    /*---------------Attribute-----*/
    int preis;
    boolean verkauft;
    Spieler besitzer;
    Straße straße;
    int grundstücksID;
    private final int basis_miete = 25;

    /*---------------Konstruktor---*/
    public Einkaufszentrum(Spieler besitzer, Straße straße, int id) {
        this.besitzer = besitzer;
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
