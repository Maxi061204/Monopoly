



import java.io.Console;

public class Mensch extends Spieler
{
    public Mensch(int geld, Spiel spiel, String name)
    {
        super(geld, spiel, name);
    }

    public boolean do_action()
    {
        Console input = System.console();
        return input.readLine().equals("ja");
    }

    public boolean handeln_consent_GS(Spieler wer, Grundstück wo, int wieviel){
        //String hatgefragt = wer.name;
        String wojetzt = wo.strassenname;
        Console input = System.console();
        System.out.println("will"+wojetzt+"für"+wieviel+"kaufen. Akzeptierst du?");        
        if(input.readLine().equals("ja")){
            return true;
        }
        return false;
    }
    
    public String get_desired_property(){
        return "FAILURE";
    }
    
    
     

    public void geld_überweisen(Spieler spieler, int geld){}

    public boolean build_extension(Grundstück building, int geld){
        return false;
    }

    public void andere_aktionen(){};

    public void angebot_unterbreiten(Feld angebot, int geld){};

    public boolean buy(Grundstück grundstück){
        return false;};

    public void zahlen(int preis){};

    public boolean buy(Kraftwerk kraftwerk){
        return false;};

    public boolean buy(Einkaufszentrum zentrum){
        return false;};

    public void in_frei_parken_zahlen(int geld){};

    public Feld get_estate(){
        return null;};

    public int get_fee(Feld est){
        return -1;};

    public int offer(Property p){
        
        return 1;
    }

}
