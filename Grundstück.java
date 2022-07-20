/**
 * Klasse Grundstück.
 *  
 * @author 
 */
public class Grundstück extends Feld{
    /*---------------Attribute----------*/
    int preis;
    int häuser;
    String strassenname;
    boolean hotel;
    int hypothekAuflösen;
    int hypothekenpreis;
    boolean hypothek;
    int index;
    Straße straße;
    boolean verkauft;
    int miete;
    int grundstücksID;
    Spieler besitzer = null;
    int haeuser_preis;

    /*---------------Konstruktor---*/
    public Grundstück(int grundstückID, Spiel spiel, String name, Straße s) {
        super(spiel, name);
        straße = s;
        DatenbankManager manager = new DatenbankManager();
        preis = manager.getGrundstückInt(grundstückID, "GrundstückPreis");
        strassenname = manager.getGrundstückString(grundstückID, "GrundstückName");
        hypothekAuflösen = manager.getGrundstückInt(grundstückID, "HypothekAuflösen");
        hypothekenpreis = manager.getGrundstückInt(grundstückID, "Hypothek");
        miete = manager.getGrundstückInt(grundstückID, "GrundstückMiete");
        grundstücksID = grundstückID;

        System.out.println("Du bist auf der Straße '" + strassenname + "' gelandet!");
    }

    /*---------------Methoden------*/    

    public void AktionAusfuehren(Spieler spieler) {
        if(spieler == null){
            if(spieler.buy(this)){
                besitzer = spieler;
                straße.gekauft(grundstücksID, spieler);
            }
        }
        if(spieler == besitzer){
            while(spieler.build_extension(this)){
                if(häuser < 4){
                    if(spieler.geld() < haeuser_preis){
                        System.out.println("Nicht genügend Geld");
                        return;
                    }else{
                        spieler.zahlen(haeuser_preis);
                        ++häuser;
                    }
                }else{
                    if(spieler.geld() < haeuser_preis){
                        System.out.println("Nicht genügend Geld");
                        return;
                    }else{
                        spieler.zahlen(haeuser_preis);
                        hotel = true;
                    }
                }
            }
        }else{
            spieler.zahlen(mieteBerechnen());
        }
    }
    
    private void kaufen(Spieler spieler, int grundstücksID){
        


        

    }
    
    
    

    

    private void miete(Spieler spieler, int grundStücksID){

        // grundstücksID = manager.getGrundstücksID() ...
        if(verkauft == true && spieler != besitzer){
            miete = mieteBerechnen();
            //miete wird vom aktuellen spieler zum besitzer übertragen
        }


    }
    
    /*private void mieteBerechnen(int miete, int grundstücksID){

        miete = manager.getGrundstückInt(grundstücksID,  "GrundStückMiete");


    }*/

    


    private int mieteBerechnen(){

        if(hotel){
            miete = miete*125;
            return miete;
        }if(häuser == 4){
            miete = miete*80;
            return miete;
        }if(häuser == 3){
            miete = miete*45;  
            return miete;
        }if(häuser == 2){
            miete = miete*10;
            return miete; 
        }if(häuser == 1){
            miete = miete*5;
            return miete;
        }if(häuser == 0){
            miete = miete;
            return miete; 
        }
        return -1;
    }

    private void hypothekSetzen(Spieler spieler){
        if(verkauft == true && spieler != besitzer && hypothek == false){
            //hypothekenpreis = manager = getHypothekenpreis();
            hypothek = true; 
            //spieler bekommt den hypothekenrpreis
        }
    }

    public void hypothekAuflösen(Spieler spieler){
        if(verkauft == true && spieler != besitzer && hypothek == true){
            //hypothekenpreis = manager = getHypothekenpreis();
            hypothek = false;
            //spieler muss hypothekenpreis + 10% zahlen
        }
    }

    private void hausBauen(int grundstücksID, int hauspreis, Spieler spieler){
        
        if(häuser >= 4) {
            hotel = true;
            häuser = 0;
        }
        
        if (hotel){
            System.out.println("Weiterer Hausbau auf diesem Grundstück nicht möglich!");
        }
        häuser++;
        spieler.zahlen(hauspreis);
    }


}
