import java.util.Random;

public abstract class Vijanden extends Wezens
{
    protected Random random;
    protected String description;
    protected int aanvalswapen;
    protected int verdediginswapen;
    
    /**
     * Constructor for objects of class Monsters
     */
    public Vijanden(String description)
    {
        random = new Random();
        this.description = description;
        aanvalswapen = 1;
        verdediginswapen = 1;
    }
    
    public String getDescription() {return description;}
    
    public int getKrachtAanvalswapen() {return aanvalswapen;}
    
    public int getKrachtVerdedigingsWapen() {return verdediginswapen;}
    
    abstract public void ontmoeten(Speler speler);
}