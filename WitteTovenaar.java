
public class WitteTovenaar extends Tovenaars
{
	public WitteTovenaar(String description)
    {super(description);}
    
    public void ontmoeten(Speler speler)
    {
        speler.wijzigEnergie(energieVerschil);
        wijzigEnergie(-energieVerschil);
        System.out.println("De tovenaar geeft U " + energieVerschil + " Hp bij.");
    }
}