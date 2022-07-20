
import java.util.Random;

/**
 * Klasse Gemeinschaftskarte.
 *  
 * @author 
 */
public class Gemeinschaftskarte extends Karte{
    /*---------------Attribute-----*/

    public DatenbankManager manager;
    /*---------------Konstruktor---*/
    public Gemeinschaftskarte() {
        manager = new DatenbankManager();
    }

    /*---------------Methoden------*/    
    public int ziehen() {
        int randomZahl = new Random().nextInt(kartenAnzahl);
        return GemeinschaftskarteZiehen(randomZahl);
    }

    //Gemeinschaftsfeld/Ereignisfeld: karteziehen  bekommt Geld / muss geld zahlen / muss auf anderes Feld / bekommt ausgefängnisfrei karte / andere Spieler bekommen geld oder müs
    
    
    private int GemeinschaftskarteZiehen(int zahl){
        String karte = manager.getKartenText("Gemeinschaftskarten", zahl);
        int aktionsID = manager.getKartenAktionsID("Gemeinschaftskarten", zahl);
        System.out.println("Gemeinschaftskarte Text: " + karte);
        System.out.println("Gemeinschaftskarte aktionsID: " + aktionsID);
        return aktionsID;
        
    }    


}



