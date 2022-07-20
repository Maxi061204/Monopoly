





import java.util.ArrayList;

public class Spiel
{
    public Spieler[] spieler;
    int an_der_reihe = 0;
    Spielbrett brett;
    private final int start_geld = 800;
    private int gefaengnis = -1;

    public Spiel(String[] namen)
    {
        spieler = new Spieler[namen.length];
        for(int i = 0; i < spieler.length; ++i){
            spieler[i] = new Mensch(start_geld, this, namen[i]);
        }
        brett = new Spielbrett(namen.length, this);
        for(int i = 0; i < spieler.length; ++i) {
            spieler[i] = new Mensch(start_geld, this, namen[i]);
        }
        brett = new Spielbrett(namen.length, this);
        for(String s : namen) {
            System.out.println("Spieler: " + s);
        }
    }

    public Property get_prop(String name){
        return brett.get_prop(name);
    }
    
    public Spieler get_spieler(String name){
        for(Spieler s : spieler){
            if(s.name().equals(name)){
                return s;
            }
        }
        return null;
    }
    
    private void next_circle(){
        Spieler aktuell = spieler[an_der_reihe%spieler.length];
        while(aktuell.muss_aussetzen > 0){
            int[] wuerfel = aktuell.wuerfeln();
            if(wuerfel[0] == wuerfel[1]){
                aktuell.muss_aussetzen = 0;
                break;
            }

            ++an_der_reihe;
            --aktuell.muss_aussetzen;
            aktuell = spieler[an_der_reihe % spieler.length];
        }

        int[] w = aktuell.wuerfeln();

        if(w[0] == w[1]){
            ++aktuell.counter;
            if(aktuell.counter == 3){
                aktuell.counter = 0;
                send_to_prison(aktuell);
                ++an_der_reihe;
                return ;
            }
        }else{
            aktuell.counter = 0;
            ++an_der_reihe;
        }
        
        aktuell.letzter_wurf = w[0] + w[1];
        brett.verschieben(aktuell.letzter_wurf, aktuell);

        //an_der_reihe += 1 - ((pasch) ? 1: 0);
        
        
    }

    public void lost(Spieler spieler){
        System.out.println(spieler.name() + " hat verloren!");
        System.exit(0);
    }
    
    public void send_to_prison(Spieler spieler){
        spieler.muss_aussetzen = 3;
        brett.send_to_prison(spieler);
    }

    /*Zeile = index / 5 (int)
    Spalte =    */

    private void loop(){
        while(true){
            //überprüfen ob Spiel gewonnen, wenn ja break;
            next_circle();//
        }
    }

    /*
    public boolean get_player_input(){
    return spieler[an_der_reihe].do_action();
    }
     */
    public void in_frei_parken_zahlen(int geld){
        brett.geld_zu_frei_parken(geld);
    }
    public void frei_parken(Spieler spieler){
        brett.frei_parken(spieler);
    }
    
    public void next_train_station(Spieler spieler){
        brett.next_train_station(spieler);
    }
    
    public void auf_los(Spieler spieler){
        brett.auf_los(spieler);
    }
}

