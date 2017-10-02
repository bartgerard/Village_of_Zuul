
public abstract class Deuren
{
    protected String description;
    protected int hpDeur;
    protected Kamer kamer1, kamer2;
    protected String dir1, dir2;
    
    public Deuren (String descr, String dir1, Kamer kamer1, String dir2, Kamer kamer2, int getal)
    {
        this.description = descr;
        this.kamer1 = kamer1;
        this.kamer2 = kamer2;
        this.dir1 = dir1;
        this.dir2 = dir2;
    }
    
    public boolean deurAanwezig(Kamer kamer, String dir)
    {
        if ( ( (kamer.equals(kamer1) && dir.equals(dir1) ) || ( (kamer.equals(kamer2)) && dir.equals(dir2)) ) && (hpDeur > 0) )
        {return true;}
        else
        {return false;}
    }
    
    public boolean deurAanwezig(Kamer kamer)
    {
        if ( (kamer.equals(kamer1) || (kamer.equals(kamer2)) ) && (hpDeur > 0) )
        {return true;}
        else
        {return false;}
    }
    
    public String tekstDeur(Kamer kamer)
    {
        String tekst;
        
        if (kamer.equals(kamer1))
            tekst = description + " verhindert uw pad (" + dir1 + ")";
        else
            tekst = description + " verhindert uw pad (" + dir2 + ")";
        return tekst;
    }
    
    public int getHpDeur() {return hpDeur;}
    
    public void setHpDeur(int Hp) {hpDeur = Hp;}
    
    abstract public void schietDeur();
    
    abstract public void openDeur(int getal);
    
    abstract public void molesteerDeur();
}