
public class Sleutel extends Item
{
    private int nummerSleutel;
    
    public Sleutel(String description, int gewicht, int nummerSleutel)
    {
        super(description, gewicht, nummerSleutel);
        this.nummerSleutel = nummerSleutel;
    }
    
    public String gebruik() {return "open deur";}
    
    public int getKrachtVerdedigingsWapen() {return 0;}
    
    public int getKrachtAanvalsWapen() {return 0;}
}