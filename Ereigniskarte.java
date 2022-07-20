import java.util.Random;

/**
 * Klasse Ereigniskarte.
 *  
 * @author 
 */
public class Ereigniskarte extends Karte{
    /*---------------Attribute-----*/

    public DatenbankManager manager;

    /*---------------Konstruktor---*/
    public Ereigniskarte() {
        manager = new DatenbankManager();
    }

   
    public int AktionAusfuehren(Spieler spieler) {
        int randomZahl = new Random().nextInt(kartenAnzahl);
        int id = EreigniskarteZiehen(spieler, randomZahl);
        
        return id;
    }
    
    private int EreigniskarteZiehen(Spieler spieler, int zahl) {
        String kartenText = manager.getKartenText("Ereigniskarten", zahl);
        int aktionsID = manager.getKartenAktionsID("Ereigniskarten", zahl);
        System.out.println("Ereigniskarte Text: " + kartenText);
        System.out.println("Ereigniskarte AktionsID: " + aktionsID);
        return aktionsID;
    }
    
    public void EreigniskarteZiehen(){
        System.out.println("text");
    }
}
    

