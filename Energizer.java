/**
 * Energetisch Product
 */
public class Energizer extends Item
{
    public Energizer(String description, int gewicht, int energetischeWaarde)
    {super(description, gewicht, energetischeWaarde);}

    public String gebruik() {return "genees speler";}
    
    public int getKrachtVerdedigingsWapen() {return 0;}
    
    public int getKrachtAanvalsWapen() {return 0;}
}
// Het soort energetischproduct wordt bepaald door de description :
// Verbanddoos, KleinVoedselPakket, GrootVoedselPakket, ShotAdrenaline