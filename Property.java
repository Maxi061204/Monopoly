
/**
 * Beschreiben Sie hier die Klasse Property.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Property extends Feld
{
    // hypothekSetzen; hypothek; hypothek_aufkösen
    Spieler besitzer = null;
    Straße straße = null;
    int grundstücksID;
    
    public Property(Spiel spiel, String name, Straße s, int i)
    {
        super(spiel, name);
        straße = s;
        grundstücksID = i;
        straße.add(this, grundstücksID);
    }
    
    public abstract boolean has_hypothek();
    
    public abstract int hypothek();
    
    public abstract int hypothek_auflösen();
    
    public abstract void hypothekAuflösen();
    
    public abstract int hypothek_setzen();
    
    public abstract int preis();
    
    public abstract int delete_extensions();
    
    public Spieler besitzer(){return besitzer;}
}
