public abstract class Tovenaars extends Vijanden
{
    protected float energieVerschil;
    
    public Tovenaars(String description)
    {
        super(description);
        energieVerschil = getEnergie()/4;
    }
}