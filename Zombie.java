/**
 * Zombies geven je een willekeurig aantal slagen (met een maximum van 5)
 * met een stuk verband dat dienst doet als zweep. Zo een slag kost je een
 * energiepunt.
 */
public class Zombie extends Vijanden
{
    private int maxAantalSlagen = 5;
    
    public Zombie(String description)
    {super(description);}
    
    public void ontmoeten(Speler speler)
    {
        int aantalSlagen = random.nextInt(maxAantalSlagen + 1);
        speler.wijzigEnergie(-aantalSlagen);
        System.out.println("De zombie geeft U " + aantalSlagen + " slagen. Dit kost U " + aantalSlagen + " Hp.");
    }
}