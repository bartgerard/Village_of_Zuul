
public class HoutenDeur extends Deuren
{
	public HoutenDeur(String descr, String dir1, Kamer kamer1, String dir2, Kamer kamer2, int getal)
	{
        super(descr, dir1, kamer1, dir2, kamer2, getal);
        hpDeur = 2;
	}
	
    public void molesteerDeur()
    {
        hpDeur --;
        if (hpDeur > 0)
            System.out.println("Na de slag vliegen slechts kleine stukjes hout in het rond. Probeer nog een keer!");
        if (hpDeur == 0)
            System.out.println("De deur heeft het begeven");
    }
    
    public void schietDeur()
    {
        hpDeur -= 2;
        if (hpDeur == 0)
            System.out.println("De deur vliegt in stukken van elkaar");
    }
    
    public void openDeur(int getal) {System.out.println("De sleutel past niet");}
}