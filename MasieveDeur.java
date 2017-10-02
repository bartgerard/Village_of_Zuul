
public class MasieveDeur extends Deuren
{
    private int nummerSleutelGat;
    
    public MasieveDeur(String descr, String dir1, Kamer kamer1, String dir2, Kamer kamer2, int nummerSleutelGat)
    {
        super(descr, dir1, kamer1, dir2, kamer2, nummerSleutelGat);
        hpDeur = 1;
        this.nummerSleutelGat = nummerSleutelGat;
    }
    
    public void openDeur(int nummerSleutel)
    {
        if (nummerSleutelGat == nummerSleutel) {
            hpDeur = 0;
            System.out.println("De sleutel past! De deur gaat open!");
        }
        else {System.out.println("De sleutel past niet!");}
    }
    
    public void schietDeur() {System.out.println("Dit heeft totaal geen effect");}
    
    public void molesteerDeur() {System.out.println("Je slag is waardeloos");}
}