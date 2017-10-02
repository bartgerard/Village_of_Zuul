import java.util.Stack;

public abstract class Wezens
{
    protected float energie;
    protected int maxEnergie = 100;
    protected Kamer huidigeKamer;
    
    public Wezens()
    {
        energie = maxEnergie;
    }
    
    public boolean isLevend() {
        if (energie > 0)
            return true;
        else
            return false;
    }
    
    public float getEnergie() {return energie;}
    
    public void setEnergie(float getal) {energie = getal;}
    
    public void wijzigEnergie(float wijziging)
    {        
        if (energie + wijziging > maxEnergie)
            energie = maxEnergie;
        if (energie + wijziging < 0)
            energie = 0;
        if (energie + wijziging >= 0 && energie + wijziging <= maxEnergie)
            energie += wijziging;
    }
    
    /**
     * schadeAanTegenstander = 10 * eigenEnergie * krachtAanvalswapen/100;
     */
    public float aanvallen(int krachtAanvalswapen)
    {
        float schadeAanTegenstander = 10 * getEnergie() * krachtAanvalswapen /100;
        return schadeAanTegenstander;
    }
    
    /**
     * echteSchade = krachtVanOntvangenMep * 20 / eigenEnergie * krachtBeschermingsvoorwerp
     */
    public float verdedigen(float krachtVanOntvangenMep, int krachtBeschermingsVoorwerp)
    {
        if (krachtBeschermingsVoorwerp < 1) {krachtBeschermingsVoorwerp = 1;}
        float echteSchade = krachtVanOntvangenMep * 20 / (getEnergie() * krachtBeschermingsVoorwerp);
        return echteSchade;
    }
    
    public Kamer getHuidigeKamer() {return huidigeKamer;}

    public void setHuidigeKamer(Kamer r) {huidigeKamer = r;}

    public void gotoKamer(Kamer kamer)
    {
        kamer = kamer.teleporteer(kamer);
        setHuidigeKamer(kamer);
    }
}