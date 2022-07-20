public class Straße {
    Spieler spieler = null;
    Property[] row;
    
    public Straße(int groeße) {
        row = new Property[groeße];
    }
    
    public void add(Property prop, int index){
        row[index] = prop;
    }
    
    public void gekauft(Spieler spieeler){
        Spieler owner = row[0].besitzer();
        for(int j = 1; j < row.length; ++j){
            if(owner != row[j].besitzer()){
                spieler = null;
                return;
            }
        }
        spieler = spieeler;
    }
    
    public int hypothek_return(){
        int ret = 0;
        for(Property p : row){
            ret += p.delete_extensions();
        }
        return ret;
    }
    
    public boolean straße_komplett(){
        return spieler != null;
    }
    
    public int count(Spieler spieler){
        int c = 0;
        for(int i = 0; i < row.length; ++i){
            if(spieler == row[i].besitzer() && !row[i].has_hypothek()){++c;}
        }
        return c;
    }
    
    public Spieler straße_gehört(){
         return spieler;
    }
    
    public boolean can_extend(Spieler sp){
        if(sp != spieler){return false;}
        if(count(sp) != row.length){return false;}
        return true;
    }
}
