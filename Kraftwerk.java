
/**
 * Klasse Kraftwerk.
 *  
 * @author 
 */
public class Kraftwerk extends Property {
    /*---------------Attribute-----*/
    private Spieler besitzer = null;
    private final int hypothek_setzen = 100;
    private final int hypothek_auflösen = 100;
    private boolean hypothek = false;
    private final int preis = 150;

    /*---------------Konstruktor---*/
    public Kraftwerk(Spiel spiel, String name, int id, Straße straße) {
        super(spiel, name, straße, id);
    }
    
    public int hypothek(){return 100;}
    
    //public void hypothek_setzen()
    
    public int preis(){return preis;}
    
    public void AktionAusfuehren(Spieler spieler){
        System.out.println("Du bist auf dem "+ name + " gelandet");
        if(besitzer == null){
            if(spieler.buy(this)){
                besitzer = spieler;
                straße.gekauft(spieler);
            }
        }else{
            if(besitzer != spieler){
                if(!hypothek)
                {
                    spieler.geld_überweisen(besitzer, miete(besitzer));
                }   
            }
        }
    }
    
    public boolean has_hypothek(){return hypothek;}
    
    public int hypothek_setzen(){
        hypothek = true;
        return hypothek_setzen;
    }
    
    public int hypothek_auflösen(){return hypothek_auflösen;}
    
    public void hypothekAuflösen(){hypothek = false;}
    
    public int delete_extensions(){return 0;}
    
    /*---------------Methoden------*/    

    private int miete(Spieler spieler){
        int c = straße.count(besitzer);
        if(c == 1){
            return 4 * spieler.letzter_wurf;
        }
        return 10 * spieler.letzter_wurf;
    }
}
