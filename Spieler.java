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
   private LinkedList<Grundstück> hypotheken = new LinkedList<Grundstück>();
   private ArrayList<Feld> besitz = new ArrayList<Feld>();
   public int gefaengnis_frei = 0;
   public String name;
   //
   
   //int[][] grundstuecke = new int[][]
   //
    public Spieler(int geld, Spiel spiel, String name)
    {
        this.geld = geld;
        this.spiel = spiel;
        this.name = name;
    }
    
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
    
    public abstract boolean build_extension(Grundstück building);
    
    public abstract void andere_aktionen();/*{
        if(hypotheken.getFirst() == null){
            System.out.println("Welches Objekt wollen Sie von einem anderen Spieler erwerben?");
            Feld estate = get_estate();
            estate.besitzer.angebot_unterbreiten(estate, get_fee(estate));
        }
        System.out.println("Möchten Sie");//not finished
    }*/
    
    public abstract void angebot_unterbreiten(Feld angebot, int geld);
    
    public abstract void zahlen(int preis);
    
    public abstract boolean buy(Grundstück grundstück);
    
    public abstract boolean buy(Kraftwerk kraftwerk);
    
    public abstract boolean buy(Einkaufszentrum zentrum);
    
    public void geld_geben(int g){
        geld += g;
    }
    
    public abstract void in_frei_parken_zahlen(int geld);
    
    public int geld(){return geld;}
    
    public void gefaengnis_frei(){++ gefaengnis_frei;}
    
    public abstract Feld get_estate();
    public abstract int get_fee(Feld est);
    
    public void handeln(Grundstück grundstück, Spieler p1, Spieler p2, int price){
    //p1 verkauft an p2 :)))))
    /*if(kill me)
    grundstück.besitzer=p2;
    p2.zahlen(price);
    p1.geld_geben(price);*/
    
    
    }
    
    public boolean handeln_consent_KW(Spieler wer, Feld wo, int wieviel){
        String hatgefragt = wer.name;
        String wojetzt = wo.name;
        Console input = System.console();
        System.out.println(hatgefragt +" will "+ wojetzt + " für " + wieviel + " kaufen. Akzeptierst du?");        
        String s = input.readLine();
        if(s.equals("ja")){
          return true;
        }
        return false;
    }
    
    public void add_property(Feld feld){
        //Nicht fertig
    }
}
