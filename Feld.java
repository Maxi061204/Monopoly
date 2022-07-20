
/**
 * Abstrakte Klasse Karte 
 * 
 * @author 
 */
public abstract class Feld {
    String name;
    Spiel spiel;
    
    public Feld(Spiel spiel, String name){
        this.spiel = spiel;
        this.name = name;
    }
    
    public abstract void AktionAusfuehren(Spieler spieler);
    
    
}
