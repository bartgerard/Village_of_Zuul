
public class Geweer extends Item
{
    public Geweer(String description, int gewicht, int sterkte)
    {super(description, gewicht, sterkte);}

    public String gebruik() {return "schiet deur";}
    
    public int getKrachtVerdedigingsWapen() {return 0;}
    
    public int getKrachtAanvalsWapen() {return getGetal();}
}