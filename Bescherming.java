/**
 * Bescherming --> look zal een beschermings voorwerp worden met sterkte nul
 * maar door zijn naam toch effectief
 */
public class Bescherming extends Item
{
	public Bescherming(String description, int gewicht, int sterkte)
	{super(description, gewicht, sterkte);}

    public String gebruik() {return "";}
    
    public int getKrachtVerdedigingsWapen() {return getGetal();}
    
    public int getKrachtAanvalsWapen() {return 0;}
}