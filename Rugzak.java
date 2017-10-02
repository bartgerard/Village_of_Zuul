import java.util.ArrayList;
import java.util.Iterator;

public class Rugzak
{
    private String description;
    private ArrayList items;
    private int maxGewicht = 50;
    private int huidigGewicht;
    
    public Rugzak(String description)
    {
        this.description = description;
        items = new ArrayList();
        huidigGewicht = 0;
    }
    
    /**
     * er wordt een voorwerp aan de speler zijn rugzak toegevoegd
     * @param i the item you want to add
     */
    public void addItem(Item i)
    {
            items.add(i);
            huidigGewicht += i.getGewicht();
    }
    
    public boolean dragenMogelijk(Item i)
    {
        if (i.getGewicht() + huidigGewicht <= maxGewicht) {return true;}
        else {
            System.out.println();
            System.out.println("Meer kunt u echt niet dragen");
            return false;
        }
    }
    /**
     * removes an item
     * @param i the item you want to remove
     */
    public void removeItem(Item i)
    {
        items.remove(i);
        huidigGewicht -= i.getGewicht();
    }
    
    /**
     * returns the item with the given description
     * @param name tge description of the item
     * @returns the item if found, otherwise <code>null</code> 
     */
    public Item getItem(String name)
    {
        Item result = null;
        for(Iterator iter = items.iterator();iter.hasNext();) {
            Item i = (Item)iter.next();
            if(i.getDescription().equals(name)) {result = i;}
        }
        return result;
    }
    
    public boolean gotItem(String name)
    {
        boolean result = false;
        for(Iterator iter = items.iterator();iter.hasNext();) {
            Item i = (Item)iter.next();
            if(i.getDescription().equals(name)) {result = true;}
        }
        return result;
    }
    
    public void getItemsString()
    {
        String returnString = "Voorwerpen:";
        for(Iterator iter = items.iterator();iter.hasNext();){
            Item i = (Item)iter.next();
            returnString += " " + i.getDescription() + " (" + i.getGewicht() + ")";
        }
        System.out.println();
        System.out.println(returnString);
    }
    
    public ArrayList getItemsArrayList()
    {
        ArrayList arraylist = (ArrayList) items.clone();
        return arraylist;
    }
    
    public void setItemsArrayList(ArrayList arraylist)
    {
        items = arraylist;
    }
    
    public int getAanvalsKracht()
    {
        int aanvalsKracht = 0;
        for(Iterator iter = items.iterator();iter.hasNext();){
            Item i = (Item)iter.next();
            aanvalsKracht += i.getKrachtAanvalsWapen();
        }
        if (aanvalsKracht == 0) {aanvalsKracht = 1;}
        return aanvalsKracht;
    }
    public int getVerdedigingsKracht()
    {
        int verdedigingsKracht = 0;
        for(Iterator iter = items.iterator();iter.hasNext();){
            Item i = (Item)iter.next();
            verdedigingsKracht += i.getKrachtVerdedigingsWapen();
        }
        if (verdedigingsKracht == 0) {verdedigingsKracht = 1;}
        return verdedigingsKracht;
    }
}