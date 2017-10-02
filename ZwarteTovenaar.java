
public class ZwarteTovenaar extends Tovenaars
{
	public ZwarteTovenaar(String description)
    {super(description);}
    
    public void ontmoeten(Speler speler)
    {
        speler.wijzigEnergie(-energieVerschil);
        wijzigEnergie(energieVerschil);
        System.out.println("De tovenaar neemt U " + energieVerschil + " Hp af.");
    }
}