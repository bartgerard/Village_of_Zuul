
public class GrijzeTovenaar extends Tovenaars
{
    private double kansOpPositief = 0.5;
    
    public GrijzeTovenaar(String description)
    {super(description);}
    
    public void ontmoeten(Speler speler)
    {
        if (random.nextFloat() <= kansOpPositief) {
            speler.wijzigEnergie(energieVerschil);
            wijzigEnergie(-energieVerschil);
            System.out.println("De tovenaar geeft U " + energieVerschil + " Hp bij.");
        }
        else {
            speler.wijzigEnergie(-energieVerschil);
            wijzigEnergie(energieVerschil);
            System.out.println("De tovenaar neemt U " + energieVerschil + " Hp af.");
        }
    }
}
