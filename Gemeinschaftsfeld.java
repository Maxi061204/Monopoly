
/**
 * Klasse Gemeischaftskarte.
 *  
 * @author 
 */
public class Gemeinschaftsfeld extends Feld {
    /*---------------Attribute-----*/


    /*---------------Konstruktor---*/
    public Gemeinschaftsfeld() {
    }
     public void AktionAusfuehren(Spieler spieler){
        Gemeinschaftskarte g = new Gemeinschaftskarte();
         System.out.println("Du ziehst eine Gemeinschatskarte");
        int id = g.AktionAusfuehren(spieler);
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
                for(Spieler sp :spiel.spieler){
                    spieler.geld_überweisen(spieler, 25);
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
