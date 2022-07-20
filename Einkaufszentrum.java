
/**
 * Klasse Einkaufszentrum.
 *  
 * @author 
 */
public class Einkaufszentrum extends Property {
    /*---------------Attribute-----*/
    int preis = 200;
    boolean verkauft = false;
    Spieler besitzer = null;
    boolean hypothek = false;
    private final int basis_miete = 25;

    /*---------------Konstruktor---*/
    public Einkaufszentrum(Spiel spiel, String name, Straße straße, int id) {
        super(spiel, name, straße, id);
    }
    
    public int hypothek_setzen(){
        hypothek = true;
        return hypothek_setzen;
    }
    
    public int preis(){return preis;}
    
    public int delete_extensions(){return 0;}
    
    public void AktionAusfuehren(Spieler spieler){
        System.out.println("Du bist auf dem" +"Bahnhof gelandet" +"Zahle x&$ an spieler");
        if(spieler == null){
            if(spieler.buy(this)){
                besitzer = spieler;
                straße.gekauft(spieler);
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
