public class Spielbrett
{
    private Feld[] felder;
    private Straße[] straßen;
    private Spiel spiel;
    
    private final int gefaengnis = 10;
    private int frei_parken = 0;
    
    public Spielbrett(int anzahlSpieler, Spiel spiel)
    {
        this.spiel = spiel;
        felder = new Feld[40];
        straßen = new Straße[8];
        felder[0] = new Los("Los", spiel);
        int[] pos = {1,3};
        String[] names = {"Ku1", "Ku2"};
        init_grund(pos, names);
    }
        //int grundstückID, Spiel spiel, String name, Straße s
    private void init_grund(int[] positionen, String[] namen){
        Straße s = new Straße(positionen.length);
        for(int i = 0; i < positionen.length; ++i){
            felder[positionen[i]] = new Grundstück(i, spiel, namen[i], s);
        }
    }
//

    
    public void next_train_station(Spieler spieler){
        int pos_bef = spieler.position;
        do{
            spieler.position = (++spieler.position) % 40;
        }while(!(felder[spieler.position] instanceof Einkaufszentrum));
        
        if(pos_bef > spieler.position){
            spieler.geld_geben(200);
        }
        felder[spieler.position].AktionAusfuehren(spieler);
    }    
    
    public void verschieben(int distanz, Spieler spieler){
        int pos_davor = spieler.position;
        spieler.position = (pos_davor + distanz)%40;
        if(spieler.position < pos_davor){
            felder[0].AktionAusfuehren(spieler);
        } 
        
        felder[spieler.position].AktionAusfuehren(spieler);
        spieler.andere_aktionen();
    }
    
    public void send_to_prison(Spieler spieler){
        spieler.position = gefaengnis;
    }
    
    public void frei_parken(Spieler spieler){
        spieler.geld_geben(frei_parken);
        frei_parken = 0;
    }
    
    public void geld_zu_frei_parken(int geld){
        frei_parken += geld;
    }
    
    public void auf_los(Spieler spieler){
        felder[0].AktionAusfuehren(spieler);
    }
}
