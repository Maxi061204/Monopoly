
/**
 * Klasse Ereignisfeld.
 *  
 * @author 
 */
public class Ereignisfeld extends Feld {
    /*---------------Attribute-----*/


    /*---------------Konstruktor---*/
    public Ereignisfeld() {
    }
     public void AktionAusfuehren(Spieler spieler){
        Ereigniskarte e = new Ereigniskarte();
        System.out.println("Du ziehst eine Ereigniskarte");
        int id = e.AktionAusfuehren(spieler);
        switch(id){
            case 0:
                //bekommt geld
                spieler.geld_geben(250);
                break;
            case 1: 
                spieler.in_frei_parken_zahlen(200);
                break;
            case 2: 
                spiel.send_to_prison(spieler);
                break;
            case 3: 
                ++spieler.gefaengnis_frei;
                break;
            case 4: 
                for(Spieler sp : spiel.spieler){
                    spieler.geld_überweisen(sp, 25);
                }
                break;
            case 5:
                //nächster bahnhof
                spiel.next_train_station(spieler);
                break;
            case 6:
                spiel.auf_los(spieler);
                break;
        }
    }

    /*---------------Methoden------*/    

    
    
}
