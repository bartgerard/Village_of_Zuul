
public class Zwaard extends Item
{    
    public Zwaard(String description, int gewicht, int getal)
    {super(description, gewicht, getal);}

    public String gebruik() {return "klop deur";}
    
    public int getKrachtVerdedigingsWapen() {return 0;}
    
    public int getKrachtAanvalsWapen() {return getGetal();}
}