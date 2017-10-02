
public abstract class Item
{
    protected String description;
    protected int gewicht;
    protected int getal;

    public Item(String description, int gewicht, int getal)
    {
        // initialise instance variables
        this.description = description;
        this.gewicht = gewicht;
        this.getal = getal;
    }

    public String getDescription() {return description;}

    public int getGewicht() {return gewicht;}

    public int getGetal() {return getal;}
    
    abstract public int getKrachtVerdedigingsWapen();
    
    abstract public int getKrachtAanvalsWapen();
    
    abstract public String gebruik();
    
    public void winnen() {}
}