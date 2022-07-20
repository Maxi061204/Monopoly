/**
 * Klasse Grundstück.
 *  
 * @author 
 */
public class Grundstück extends Property{
    /*---------------Attribute----------*/
    int preis;
    int häuser;
    String strassenname;
    boolean hotel;
    int hypothekAuflösen;
    int hypothekenpreis;
    boolean hypothek;
    int index;
    int miete;
    int haeuser_preis;
//Spiel spiel, String name, int preis, int hypothekSetzen, int hypothek_auflösen
    /*---------------Konstruktor---*/
    public Grundstück(int grundstückID, Spiel spiel, String name, Straße s) { 
        super(spiel, name, s, grundstückID);
        DatenbankManager manager = new DatenbankManager();
        preis = manager.getGrundstückInt(grundstückID, "GrundstückPreis");
        strassenname = manager.getGrundstückString(grundstückID, "GrundstückName");
        hypothekAuflösen = manager.getGrundstückInt(grundstückID, "HypothekAuflösen");
        hypothekenpreis = manager.getGrundstückInt(grundstückID, "Hypothek");
        miete = manager.getGrundstückInt(grundstückID, "GrundstückMiete");
        
        System.out.println("Du bist auf der Straße '" + strassenname + "' gelandet!");
    }
    
    public int preis(){return preis;}
    
    public int delete_extensions(){
        int ret = hypothek() + (häuser + ((hotel) ? 1: 0)) * haeuser_preis;
        häuser = 0;
        hotel = false;
        return ret;
    }
    
    /*---------------Methoden------*/    

    public void AktionAusfuehren(Spieler spieler) {
        if(spieler == null){
            if(spieler.buy(this)){
                besitzer = spieler;
                straße.gekauft(spieler);
            }
        }
        if(spieler == besitzer)
        {
            if(straße.can_extend(besitzer))
            {
                while(spieler.build_extension(this, haeuser_preis))
                {
                    if(häuser < 4)
                    {
                        ++häuser;
                    }else
                    {
                        hotel = true;
                    }
                }
            }
        }
        else
        {
            if(!hypothek)
            {
                spieler.geld_überweisen(besitzer, mieteBerechnen());
            }
        }
    }
 

    private int mieteBerechnen(){
        if(hotel){
            return miete*125;
        }
        if(häuser == 4){
            return miete*80;
        }
        if(häuser == 3){ 
            return miete*45;
        }
        if(häuser == 2){
            return miete = miete*10; 
        }
        if(häuser == 1){
            return miete * 5;
        }
        if(häuser == 0){
            return miete; 
        }
        return -1;
    }

    public int hypothek_setzen(){
        hypothek = true;
        int ret = straße.hypothek_return() + hypothekAuflösen;
        return ret;
    }

    public int hypothek(){return hypothekenpreis;}

    public int hypothek_auflösen(){return hypothekAuflösen;}

    public void hypothekAuflösen(){
        hypothek = false;
    }

    public boolean has_hypothek(){return hypothek;}
}
