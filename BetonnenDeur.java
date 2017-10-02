
public class BetonnenDeur extends Deuren
{
	public BetonnenDeur(String descr, String dir1, Kamer kamer1, String dir2, Kamer kamer2, int getal)
	{
        super(descr, dir1, kamer1, dir2, kamer2, getal);
        hpDeur = 10;
	}
	
    public void schietDeur()
    {
        hpDeur = hpDeur - 2;
        
        if (hpDeur > 0)
            System.out.println("Het gat in de deur wordt groter. Blijf proberen!");
        if (hpDeur == 0)
            System.out.println("De deur begeeft het onder invloed van uw schot");
    }
    
    public void openDeur(int getal) {System.out.println("De sleutel past niet");}
    
    public void molesteerDeur() {System.out.println("Je slag heeft geen enkel effect");}
}