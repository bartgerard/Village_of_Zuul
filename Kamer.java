import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Class Room - a room in an adventure game.
 * 
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

public class Kamer
{
    private String description, naam;
    private int xPos, yPos, verdieping; // Coördinaten
    private HashMap exits;        // stores exits of this room.
    private ArrayList items;      // stores the items in this room
    private Set keys;

    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Kamer(String description, String naam, int xPos, int yPos, int verdieping) 
    {
        this.description = description;
        this.naam = naam;
        this.xPos = xPos;
        this.yPos = yPos;
        this.verdieping = verdieping;
        exits = new HashMap();
        items = new ArrayList();
    }
    
    public String getNaam() {return naam;}
    
    public int getXPos() {return xPos;}
    public int getYPos() {return yPos;}
    public int getVerdieping() {return verdieping;}

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     Items: mes zwaard
     */
    public String getLongDescription() {return "U staat " + description + ".\n" + "Exits:" + getExitString() + "\n" + "Items: " + getItemString();}

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    public String getExitString()
    {
        String alleExits = "";
        keys = exits.keySet();
        for (Iterator iter = keys.iterator(); iter.hasNext();)
            alleExits += " " + iter.next();
        return alleExits;
    }
    private String getItemString() {
        String alleItems = "";
        for(Iterator iter = items.iterator();iter.hasNext();) {
            Item i = (Item)iter.next();
            alleItems += i.getDescription()+ " (" + i.getGewicht() + " kg) ";
        }
        return alleItems;
    }

// Exit gerelateerd
    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Kamer neighbor) {exits.put(direction, neighbor);}
    
    public boolean hasExit(String gevraagdeRichting)
    {
        for(Iterator iter = keys.iterator();iter.hasNext();)
        {
            String richting = (String) iter.next();
            if(richting.equals(gevraagdeRichting)) {return true;}
        }
        return false;
    }
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Kamer getExit(String direction) {return (Kamer)exits.get(direction);}
    
// Item gerelateerd
    public void addItem(Item i) {items.add(i);}
    
    public void removeItem(Item i) {items.remove(i);}
    
    public Item pickUp(String name) {
        for(Iterator iter = items.iterator();iter.hasNext();) {
            Item i = (Item)iter.next();
            if(i.getDescription().equals(name)) {return i;}
        }
        return null;
    }
    public ArrayList getItemsArrayList()
    {
        ArrayList arraylist = (ArrayList) items.clone();
        return arraylist;
    }
    public void setItemsArrayList(ArrayList arraylist)
    {
        items.clear();
        items = arraylist;
    }

// Teleportatie gerelateerd
    public Kamer teleporteer(Kamer kamer) {return kamer;}
}