import java.util.ArrayList;

/**
 * This class represents a player in the game of Zuul.
 * 
 * @author P-J Drouillon
 * @version 22 feb 2007
 */
public class Speler extends Wezens
{
    // instance variables - replace the example below with your own
    private String naam;
    private Rugzak rugzak;

    /**
     * Creates a Player object with the given name and given startingplace.
     * @param name name of the player
     * @param startRoom starting room
     */
    public Speler(String naam, Kamer startKamer)
    {
        // initialise instance variables
        this.naam = naam;
        this.huidigeKamer = startKamer;
        rugzak = new Rugzak(naam + "'s rugzak");
    }
    /**
     * Om de naam van de speler op te vragen
     */
    public String getName() {return naam;}
    
    /**
     * Rugzak Related Stuff
     */
    public void addItem(Item i) {rugzak.addItem(i);}
    
    public boolean dragenMogelijk(Item i) {return rugzak.dragenMogelijk(i);}
    
    public void removeItem(Item i) {rugzak.removeItem(i);}
    
    public Item getItem(String name) {return rugzak.getItem(name);}
    
    public boolean gotItem(String name) {return rugzak.gotItem(name);}
    
    public void getItemsString() {rugzak.getItemsString();}
    
    public ArrayList getItemsArrayList()  {return rugzak.getItemsArrayList();}
    
    public void setItemsArrayList(ArrayList arraylist)  {rugzak.setItemsArrayList(arraylist);}
    
    /**
     * Aanval/Rugzak gerelateerde zaken
     */
    public int getKrachtAanvalswapen() {return rugzak.getAanvalsKracht();}
    
    public int getKrachtVerdedigingsWapen() {return rugzak.getVerdedigingsKracht();}
}