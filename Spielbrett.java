public class Spielbrett
{
    private Feld[] felder;
    private Spiel spiel;
    
    private final int gefaengnis = 10;
    private int frei_parken = 0;
    
    public Spielbrett(int anzahlSpieler, Spiel spiel)
    {
        this.spiel = spiel;
        felder = new Feld[40];
        felder[0] = new Los("Los", spiel);
        
        //initialisiere Grundstücke
        init_grund(1, 3, "Ku1", "Ku2");
        init_grund(6, 8, 9, "Chemie 1", "Chemie 2", "Chemie Übung");
        init_grund(11, 13, 14, "Bio 1", "Bio 2", "Bio Übung");
        init_grund(16, 18, 19, "Goethestr.", "Uhlandstr.", "Lessingstr");
        init_grund(21, 23, 24, "Donaupark", "Jahninsel", "Stadtpark");
        init_grund(26, 27, 29, "K08", "K09", "K10");
        init_grund(31, 32, 34, "Lehrmittelbibliothek", "Pausenverkauf", "Aula");
        init_grund(37, 39, "Sekretariat", "Direktorat");
        
        //initialisiere Gemeinschaftsfelder
        felder[2] = new Gemeinschaftsfeld(spiel, "Community Chest");
        felder[17] = new Gemeinschaftsfeld(spiel, "Community Chest");
        felder[33] = new Gemeinschaftsfeld(spiel, "Community Chest");
        
        //initialisiere Ereignisfelder
        felder[7] = new Ereignisfeld(spiel, "Tombola");
        felder[22] = new Ereignisfeld(spiel, "Tombola");
        felder[36] = new Ereignisfeld(spiel, "Tombola");
        
        //initialisiere Steuern
        felder[4] = new Einkommenssteuer(spiel, "Einkommenssteuer");
        felder[38] = new Zusatzsteuer(spiel, "Zusatzsteuer");
        
        //initialisiere Einkaufszentren
        Straße s = new Straße(4);
        felder[5] = new Einkaufszentrum(spiel, "DEZ", s, 0);
        felder[15] = new Einkaufszentrum(spiel, "Köwe", s, 1);
        felder[25] = new Einkaufszentrum(spiel, "REZ", s, 2);
        felder[35] = new Einkaufszentrum(spiel, "Arcaden", s, 3);
        
        //initialisiere Kraftwerke
        Straße s1 = new Straße(2);
        felder[12] = new Kraftwerk(spiel, "Zink", 0, s1);
        felder[28] = new Kraftwerk(spiel, "La Gondola", 1, s1);
        
        felder[gefaengnis] = new Nur_zu_Besuch(spiel, "Nur zu Besuch");
        
        felder[20] = new Frei_Parken(spiel, "Frei Parken");
        felder[30] = new Gefängnis(spiel, "Gefängnis");
    }
    
    
    private void init_grund(int pos1, int pos2, int pos3, String n1, String n2, String n3){
        Straße s = new Straße(3);
        felder[pos1] = new Grundstück(0, spiel, n1, s);
        felder[pos2] = new Grundstück(1, spiel, n2, s);
        felder[pos3] = new Grundstück(2, spiel, n3, s);
    }
    
    private void init_grund(int pos1, int pos2, String n1, String n2){
        Straße s = new Straße(3);
        felder[pos1] = new Grundstück(0, spiel, n1, s);
        felder[pos2] = new Grundstück(1, spiel, n2, s);
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
