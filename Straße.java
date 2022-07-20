public class Straße {
    Spieler spieler = null;
    Spieler[] in_besitz;
    
    public Straße(int groeße) {
        in_besitz = new Spieler[groeße];
        for(int i = 0; i < groeße; ++i){
            in_besitz[i] = null;
        }
    }
    
    public void gekauft(int i, Spieler spieeler){
        in_besitz[i] = spieeler;
        Spieler owner = in_besitz[0];
        for(int j = 1; j < in_besitz.length; ++j){
            if(owner != in_besitz[j]){
                spieler = null;
                return;
            }
        }
        spieler = spieeler;
    }
    
    public boolean straße_komplett(){
        return spieler != null;
    }
    
    public int count(Spieler spieler){
        int c = 0;
        for(int i = 0; i < in_besitz.length; ++i){
            if(spieler == in_besitz[i]){++c;}
        }
        return c;
    }
    
    public Spieler straße_gehört(){
         return spieler;
    }
}
