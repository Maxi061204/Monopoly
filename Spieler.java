import java.util.LinkedList;
import java.util.ArrayList;
import java.io.Console;


public abstract class Spieler
{
    public int position = 0;
    public int letzter_wurf = 0;
   private int geld;
   private Spiel spiel;
   public int counter = 0;
   public int muss_aussetzen = 0;
   private LinkedList<Property> hypotheken = new LinkedList<Property>();
   private ArrayList<Property> besitz = new ArrayList<Property>();
   public int gefaengnis_frei = 0;
   private String name;
   //
   
   //int[][] grundstuecke = new int[][]
   //
    public Spieler(int geld, Spiel spiel, String name)
    {
        this.geld = geld;
        this.spiel = spiel;
        this.name = name;
    }
    
    public String name(){return name;}
    
    //public abstract boolean do_action();
    
    public int[] wuerfeln(){
     int[] ergebnisse = new int[2];
     int n = (int)(Math.random()*6 + 1);
     int m = (int)(Math.random()*6 + 1);
     ergebnisse[0]=n;
     ergebnisse[1]=m;
     return ergebnisse;
    }
    //f
    
    public abstract void geld_überweisen(Spieler spieler, int geld);
    
    /*public void aktion_uebergeben(int action_id){ //Für Felder
        //Einfach Geld geben oder überweisen haben eigene Methoden(s.u.)
        switch(action_id){
            case 1: action_id = 0;
                //Geld zu frei parken
                break;
            case 2: action_id = 1;
                //anderem spieler geld überweisen
                break;
            case 3: action_id = 2;
                //haus_hotel bauen?
            case 4: 
        }
    }*/
    
    public boolean build_extension(Grundstück building, int price){
        if(!can_afford(price)){return false;}
        System.out.println("Wollen Sie für " + building.name() + " eine Erweiterung für "+ price + " bauen?");
        if(do_action()){
            zahlen(price);
            return true;
        }
        return false;
    }
    
   
    
    public abstract void andere_aktionen();
    
    public void angebot_unterbreiten(Property angebot, int geld, Spieler wer){
        System.out.println("Wollen Sie " + angebot.name()+ " für " + geld + " verkaufen?");
        if(do_action()){
            wer.geld_überweisen(this, geld);
            besitz.remove(angebot);
            wer.add_prop(angebot);
        }
    }
    
    
    
    public boolean buy(Property prop){
        if(!can_afford(prop.preis())){return false;}
        System.out.println("Wollen Sie " + prop.name() + " für " + prop.preis() + " kaufen?");
        if(do_action()){zahlen(prop.preis()); return true;}
        return false;
    }
    
    private void handeln(){
        Property prop = null;
        do{
            System.out.println("Wollen Sie handeln?");
            if(!do_action()){
                return;
            }
            String s = get_desired_property();
            prop = spiel.get_prop(s);
        }while(prop == null || !can_afford(prop.preis()));
        
        prop.besitzer().angebot_unterbreiten(prop, offer(prop), this);
    }
    
    public void add_prop(Property prop){
        besitz.add(prop);
        prop.set_besitzer(this);
    }
    
    private void zahlen(int geld){
        if(this.geld > geld){this.geld -= geld; return;}
        int g = generate_wealth(geld - this.geld);
        this.geld = this.geld - geld + g - geld; 
    }
    
    public abstract int offer(Property prop);
    
    private boolean can_afford(int moneten){
        int wealth = geld;
        int counter = 0;
        do{
            if(wealth >= moneten){
                return true;
            }
            Property prop = besitz.get(counter);
            wealth += prop.hypothek();
            
            ++counter;
        }while(counter < besitz.size());
        
        return false;
    }
    
    public abstract boolean do_action();
    
    public abstract String get_desired_property();
    
    public void geld_geben(int g){
        geld += g;
    }
    
    public Property get_prop(String n){
        for(Property p : besitz){
            if(p.name().equals(n)){
                return p;
            }
        }
        return null;
    }
    
    public void in_frei_parken_zahlen(int geld){
        if(!can_afford(geld)){spiel.lost(this);}
        int g = 0;
        if(this.geld < geld){
            g = generate_wealth(geld - this.geld);
        }
        this.geld =this.geld+ geld + g - geld;
        spiel.in_frei_parken_zahlen(geld);
    }
    
   
    private int generate_wealth(int how_much){
        int g = 0;
        do{
            String s = get_desired_property();
            Property prop = get_prop(s);
            if(prop == null){continue;}
            this.geld += prop.hypothek_setzen();
            besitz.remove(prop);
            hypotheken.add(prop);
        }while(g < how_much);
        return g;
    }
    
    public int geld(){return geld;}
    
    public void gefaengnis_frei(){++ gefaengnis_frei;}
    
    
    
    
    
}
