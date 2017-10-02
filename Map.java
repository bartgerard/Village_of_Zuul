
public class Map
{
    private Wereld wereld;
    
    public Map(Wereld wereld)
    {
        this.wereld = wereld;
    }
    
    /**
     * De klasse map geeft de aanliggende kamers weer van de huidige kamer inclusief de uitgangen van de huidige kamer.
     */
    public void toon(Kamer kamer)
    {
        int verdieping = kamer.getVerdieping();
        int xPos = kamer.getXPos();
        int yPos = kamer.getYPos();
        String links;
        String midden;
        String rechts;
        
        boolean noord = kamerAanwezig(xPos, yPos + 1, verdieping);
        boolean noordoost = kamerAanwezig(xPos + 1, yPos + 1, verdieping);
        boolean oost = kamerAanwezig(xPos + 1, yPos, verdieping);
        boolean zuidoost = kamerAanwezig(xPos + 1, yPos - 1, verdieping);
        boolean zuid = kamerAanwezig(xPos, yPos - 1, verdieping);
        boolean zuidwest = kamerAanwezig(xPos - 1, yPos - 1, verdieping);
        boolean west = kamerAanwezig(xPos - 1, yPos, verdieping);
        boolean noordwest = kamerAanwezig(xPos - 1, yPos + 1, verdieping);
        boolean omhoog = kamerAanwezig(xPos, yPos, verdieping + 1);
        boolean omlaag = kamerAanwezig(xPos, yPos, verdieping - 1);
        
        
        System.out.println("Kaart :");
        System.out.println();
        
        if (noordwest == true)  {links = "*-------------*";}
        else {links = "///////////////";}
        if (noord == true)  {midden = "*-------------*";}
        else {midden = "///////////////";}
        if (noordoost == true)  {rechts = "*-------------*";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (noordwest == true)  {links = "|             |";}
        else {links = "///////////////";}
        if (noord == true)  {midden = "|             |";}
        else {midden = "///////////////";}
        if (noordoost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        System.out.println(links + " " + midden + " " + rechts);
        if (noordwest == true)  {links = "|" + getNaamKamer(xPos - 1, yPos + 1, verdieping) + "|";}
        else {links = "///////////////";}
        if (noord == true)  {midden = "|" + getNaamKamer(xPos, yPos + 1, verdieping) + "|";}
        else {midden = "///////////////";}
        if (noordoost == true)  {rechts = "|" + getNaamKamer(xPos + 1, yPos + 1, verdieping) + "|";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (noordwest == true)  {links = "|             |";}
        else {links = "///////////////";}
        if (noord == true)  {midden = "|             |";}
        else {midden = "///////////////";}
        if (noordoost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        System.out.println(links + " " + midden + " " + rechts);
        if(noordwest == true && kamer.hasExit("noordwest"))  {links = "*------------  ";}
        else if (noordwest == true)  {links = "*-------------*";}
        else {links = "///////////////";}
        if(noord == true && kamer.hasExit("noord"))  {midden = "*-----   -----*";}
        else if (noord == true)  {midden = "*-------------*";}
        else {midden = "///////////////";}
        if(noordoost == true && kamer.hasExit("noordoost"))  {rechts = "  ------------*";}
        else if (noordoost == true)  {rechts = "*-------------*";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        
        
        if(west == true)  {links = "*-------------*";}
        else {links = "///////////////";}
        if(noord == true && kamer.hasExit("noord") && noordoost == true && kamer.hasExit("noordoost") && noordwest == true && kamer.hasExit("noordwest"))  {midden = "  ----   ----  ";}
        else if (noord == true && kamer.hasExit("noord") && noordoost == true && kamer.hasExit("noordoost"))  {midden = "*-----   ----  ";}
        else if (noord == true && kamer.hasExit("noord") && noordwest == true && kamer.hasExit("noordwest"))  {midden = "  ----   -----*";}
        else if (noordoost == true && kamer.hasExit("noordoost") && noordwest == true && kamer.hasExit("noordwest"))  {midden = "  -----------  ";}
        else if (noordwest == true && kamer.hasExit("noordwest"))  {midden = "  ------------*";}
        else if (noord == true && kamer.hasExit("noord"))  {midden = "*-----   -----*";}
        else if (noordoost == true && kamer.hasExit("noordoost"))  {midden = "*------------  ";}
        else {midden = "*-------------*";}
        if (oost == true)  {rechts = "*-------------*";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (west == true)  {links = "|             |";}
        else {links = "///////////////";}
        if (omhoog == true && kamer.hasExit("omhoog")) {midden = "| Omh         |";}
        else {midden = "|             |";}
        if (oost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (west == true)  {links = "|             |";}
        else {links = "///////////////";}
        midden = "|             |";
        if (oost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (west == true && kamer.hasExit("west"))  {links = "|" + getNaamKamer(xPos - 1, yPos, verdieping) + " ";}
        else if (west == true)  {links = "|" + getNaamKamer(xPos - 1, yPos, verdieping) + "|";}
        else {links = "///////////////";}
        if (west == true && kamer.hasExit("west") && oost == true && kamer.hasExit("oost"))  {midden = "       X       ";}
        else if (west == true && kamer.hasExit("west"))  {midden = "       X      |";}
        else if (oost == true && kamer.hasExit("oost"))  {midden = "|      X       ";}
        else {midden = "|      X      |";}
        if (oost == true && kamer.hasExit("oost"))  {rechts = " " + getNaamKamer(xPos + 1, yPos, verdieping) + "|";}
        else if (oost == true)  {rechts = "|" + getNaamKamer(xPos + 1, yPos, verdieping) + "|";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (west == true)  {links = "|             |";}
        else {links = "///////////////";}
        midden = "|             |";
        if (oost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (west == true)  {links = "|             |";}
        else {links = "///////////////";}
        if (omlaag == true && kamer.hasExit("omlaag")) {midden = "|         Oml |";}
        else {midden = "|             |";}
        if (oost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if(west == true)  {links = "*-------------*";}
        else {links = "///////////////";}
        if(zuid == true && kamer.hasExit("zuid") && zuidoost == true && kamer.hasExit("zuidoost") && zuidwest == true && kamer.hasExit("zuidwest"))  {midden = "  ----   ----  ";}
        else if (zuid == true && kamer.hasExit("zuid") && zuidoost == true && kamer.hasExit("zuidoost"))  {midden = "*-----   ----  ";}
        else if (zuid == true && kamer.hasExit("zuid") && zuidwest == true && kamer.hasExit("zuidwest"))  {midden = "  ----   -----*";}
        else if (zuidoost == true && kamer.hasExit("zuidoost") && zuidwest == true && kamer.hasExit("zuidwest"))  {midden = "  -----------  ";}
        else if (zuidwest == true && kamer.hasExit("zuidwest"))  {midden = "  ------------*";}
        else if (zuid == true && kamer.hasExit("zuid"))  {midden = "*-----   -----*";}
        else if (zuidoost == true && kamer.hasExit("zuidoost"))  {midden = "*------------  ";}
        else {midden = "*-------------*";}
        if (oost == true)  {rechts = "*-------------*";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        
        
        if (zuidwest == true && kamer.hasExit("zuidwest"))  {links = "*------------  ";}
        else if(zuidwest == true)  {links = "*-------------*";}
        else {links = "///////////////";}
        if (zuid == true && kamer.hasExit("zuid"))  {midden = "*-----   -----*";}
        else if (zuid == true)  {midden = "*-------------*";}
        else {midden = "///////////////";}
        if (zuidoost == true && kamer.hasExit("zuidoost"))  {rechts = "  ------------*";}
        else if (zuidoost == true)  {rechts = "*-------------*";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (zuidwest == true)  {links = "|             |";}
        else {links = "///////////////";}
        if (zuid == true)  {midden = "|             |";}
        else {midden = "///////////////";}
        if (zuidoost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        System.out.println(links + " " + midden + " " + rechts);
        if (zuidwest == true)  {links = "|" + getNaamKamer(xPos - 1, yPos - 1, verdieping) + "|";}
        else {links = "///////////////";}
        if (zuid == true)  {midden = "|" + getNaamKamer(xPos, yPos - 1, verdieping) + "|";}
        else {midden = "///////////////";}
        if (zuidoost == true)  {rechts = "|" + getNaamKamer(xPos + 1, yPos - 1, verdieping) + "|";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        if (zuidwest == true)  {links = "|             |";}
        else {links = "///////////////";}
        if (zuid == true)  {midden = "|             |";}
        else {midden = "///////////////";}
        if (zuidoost == true)  {rechts = "|             |";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        System.out.println(links + " " + midden + " " + rechts);
        if (zuidwest == true)  {links = "*-------------*";}
        else {links = "///////////////";}
        if (zuid == true)  {midden = "*-------------*";}
        else {midden = "///////////////";}
        if (zuidoost == true)  {rechts = "*-------------*";}
        else {rechts = "///////////////";}
        System.out.println(links + " " + midden + " " + rechts);
        
        System.out.println();
        System.out.println(" X : hier staat U");
        System.out.println(" Omh : er bevindt zich een kamer boven U");
        System.out.println(" Oml : er bevindt zich een kamer onder U");
        System.out.println();
        
    }
    
    private boolean kamerAanwezig(int xPos, int yPos, int verdieping)
    {
        Kamer kamer = wereld.getKamer(xPos, yPos, verdieping);
        if (kamer != null) {return true;}
        else {return false;}
    }
    private String getNaamKamer(int xPos, int yPos, int verdieping)
    {
        Kamer kamer = wereld.getKamer(xPos, yPos, verdieping);
        return kamer.getNaam();
    }
}
