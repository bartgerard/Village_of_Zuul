import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Random;

public class Wereld
{
    private ArrayList kamers, deuren, vijanden;
    private Kamer start;
    private Deuren kerkdeur, kerkerdeur, deurvanbordeel, tavernedeur;
    private Random random;
    
    public Wereld()
    {
        kamers = new ArrayList();
        deuren = new ArrayList();
        vijanden = new ArrayList();
        random = new Random();
        
        Kamer kerkhof, mausoleum, kerk, sacristie, altaar, klokkentoren, krotje, bordeel, slaapkamer, inkomhal, eetzaal, keuken, gallerij, bibliotheek, lab, kerkers, 
        troonzaal, terras, park, vijver, taverne, wijnkelder, provisiekamer, loopbrug;
        TelePoort krot, martelkamer, slaapzaal;
        Vijanden dracula, lupos, zombie, merlijn, saruman, gandalf;

        // create the rooms
        sacristie = new Kamer("in de sacristie", "  sacristie  ", -2, -1, 0);
        kamers.add(sacristie);
        altaar = new Kamer("bij het altaar", "   altaar    ", -1, -2, 0);
        kamers.add(altaar);
        
        gallerij = new Kamer("in de gallerij van het kasteel", "  gallerij   ", 0, 3, 0);
        kamers.add(gallerij);
        eetzaal = new Kamer("in de eetkamer", "   eetzaal   ", -1, 3, 0);
        kamers.add(eetzaal);
        bordeel = new Kamer("in het huis van plezier", "   bordeel   ", -1, 1, 0);
        kamers.add(bordeel);
        krot = new TelePoort("in een krot", "    krot     ", -1, 0, 0);
        kamers.add(krot);
        kerk = new Kamer("in de kerk", "    kerk     ", -1, -1, 0);
        kamers.add(kerk);
        
        loopbrug = new Kamer("op de loopbrug van het kasteel", "   loopbrug  ", 0, 1, 0);
        kamers.add(loopbrug);
        inkomhal = new Kamer("in de inkomhal van het kasteel", "  inkomhal   ", 0, 2, 0);
        kamers.add(inkomhal);
        start = new Kamer("op het dorpsplein", " dorpsplein  ", 0, 0, 0);
        kamers.add(start);
        kerkhof = new Kamer("op het kerkhof", "   kerkhof   ", 0, -1, 0);
        kamers.add(kerkhof);
        mausoleum = new Kamer("in het mausoleum", "  mausoleum  ", 0, -2, 0);
        kamers.add(mausoleum);
        
        keuken = new Kamer("in de keuken", "   keuken    ", -1, 2, 0);
        kamers.add(keuken);
        bibliotheek = new Kamer("in de bibliotheek van het kasteel", " bibliotheek ", 1, 2, 0);
        kamers.add(bibliotheek);
        lab = new Kamer("in het laboratorium", "    lab      ", 1, 3, 0);
        kamers.add(lab);
        park = new Kamer("in het dorpspark", "     park    ", 1, 1, 0);
        kamers.add(park);
        vijver = new Kamer("bij de vijver langs het dorpspark", "    vijver   ", 2, 1, 0);
        kamers.add(vijver);
        taverne = new Kamer("in de taverne van het dorp", "   taverne   ", 1, 0, 0);
        kamers.add(taverne);
        
        kerkers = new Kamer("bij de kerkers in de kelder van het kasteel", "   kerkers   ", 0, 2, -1);
        kamers.add(kerkers);
        wijnkelder = new Kamer("in de wijnkelder van de taverne", " wijnkelder  ", 1, 0, -1);
        kamers.add(wijnkelder);
        martelkamer = new TelePoort("in de martelkamer onder het kasteel", " martelkamer ", 0, 1, -1);
        kamers.add(martelkamer);
        
        troonzaal = new Kamer("in de troonzaal van het kasteel", "  troonzaal  ", 0, 2, 1);
        kamers.add(troonzaal);
        terras = new Kamer("op het dakterras van het kasteel", "   terras    ", 1, 3, 1);
        kamers.add(terras);
        provisiekamer = new Kamer("in de voorraadkamer van de taverne", "provisiekamer", 1, 0, 1);
        kamers.add(provisiekamer);
        slaapkamer = new Kamer("in de slaapkamer boven het bordeel", " slaapkamer  ", -1, 1, 1);
        kamers.add(slaapkamer);
        slaapzaal = new TelePoort("in de koninklijke slaapkamer", "  slaapzaal  ", 0, 3, 1);
        kamers.add(slaapzaal);
        klokkentoren = new Kamer("in de klokkentoren", "klokkentoren ", -1, -1, 1);
        kamers.add(klokkentoren);
        
        // deuren --> geef de twee randruimtes in, niet vergeten hieronder ook in de ArrayList toe te voegen
        kerkdeur = new HoutenDeur("Een grote houten kerkdeur", "zuidwest", start, "noordoost", kerk, 0);
        deuren.add(kerkdeur);
        kerkerdeur = new MasieveDeur("Een ijzeren kerkerdeur", "omlaag", inkomhal, "omhoog", kerkers, 1);
        deuren.add(kerkerdeur);
        deurvanbordeel = new BetonnenDeur("Een dikke betonnen deur", "noord", krot, "zuid", bordeel, 0);
        deuren.add(deurvanbordeel);
        tavernedeur = new HoutenDeur("De deur van de taverne", "oost", start, "west", taverne, 0);
        deuren.add(tavernedeur);

        // voorwerpen plaatsen
        taverne.addItem(new Geweer("awp", 40, 10));
        mausoleum.addItem(new Zwaard("excalibur", 30, 10));
        terras.addItem(new Geweer("deserteagle", 10, 2));
        inkomhal.addItem(new Energizer("verbanddoos", 2, 20));
        altaar.addItem(new Sleutel("sleutel", 1, 1));
        lab.addItem(new Energizer("adrenaline", 3, 50));
        start.addItem(new Bescherming("look", 1, 0));
        sacristie.addItem(new Bescherming("schild", 15, 5));
        klokkentoren.addItem(new Energizer("kleinvoedselpakket", 3, 5));
        troonzaal.addItem(new Energizer("grootvoedselpakket", 10, 15));
        
        // het plaatsen van de Beker
        int nummer = random.nextInt(kamers.size());
        Kamer randomKamer = (Kamer) kamers.get(nummer);
        randomKamer.addItem(new Beker("beker",1, 1));
        
        // initialise room exits
        start.setExit("noord", loopbrug);
        start.setExit("noordoost", park);
        start.setExit("oost", taverne);
        start.setExit("zuid", kerkhof);
        start.setExit("zuidwest", kerk);
        start.setExit("west", krot);
        start.setExit("noordwest", bordeel);

        kerkhof.setExit("noord", start);
        kerkhof.setExit("zuid", mausoleum);
        kerkhof.setExit("west", kerk);

        mausoleum.setExit("noord", kerkhof);

        kerk.setExit("noordoost", start);
        kerk.setExit("oost", kerkhof);
        kerk.setExit("zuid", altaar);
        kerk.setExit("west", sacristie);
        kerk.setExit("omhoog", klokkentoren);

        klokkentoren.setExit("omlaag", kerk);

        sacristie.setExit("oost", kerk);
        sacristie.setExit("zuidoost", altaar);

        altaar.setExit("noordwest", sacristie);
        altaar.setExit("noord", kerk);
        
        bordeel.setExit("zuidoost", start);
        bordeel.setExit("zuid", krot);
        bordeel.setExit("omhoog", slaapkamer);
        
        slaapkamer.setExit("omlaag", bordeel);
        
        park.setExit("oost", vijver);
        park.setExit("zuidwest", start);
        
        vijver.setExit("zuidwest", taverne);
        vijver.setExit("west", park);
        
        taverne.setExit("noordoost", vijver);
        taverne.setExit("west", start);
        taverne.setExit("omhoog", provisiekamer);
        taverne.setExit("omlaag", wijnkelder);
        
        wijnkelder.setExit("omhoog", taverne);
        
        provisiekamer.setExit("omlaag", taverne);
        
        loopbrug.setExit("noord", inkomhal);
        loopbrug.setExit("zuid", start);
        
        inkomhal.setExit("noord", gallerij);
        inkomhal.setExit("oost", bibliotheek);
        inkomhal.setExit("zuid", loopbrug);
        inkomhal.setExit("west", keuken);
        inkomhal.setExit("noordwest", eetzaal);
        inkomhal.setExit("omhoog", troonzaal);
        inkomhal.setExit("omlaag", kerkers);
        
        keuken.setExit("noord", eetzaal);
        keuken.setExit("oost", inkomhal);
        
        eetzaal.setExit("zuidoost", inkomhal);
        eetzaal.setExit("zuid", keuken);
        
        gallerij.setExit("oost", lab);
        gallerij.setExit("zuidoost", bibliotheek);
        gallerij.setExit("zuid", inkomhal);
        
        lab.setExit("zuid", bibliotheek);
        lab.setExit("west", gallerij);
        
        bibliotheek.setExit("noord", lab);
        bibliotheek.setExit("west", inkomhal);
        bibliotheek.setExit("noordwest", gallerij);
        
        troonzaal.setExit("noordoost", terras);
        troonzaal.setExit("noord", slaapzaal);
        troonzaal.setExit("omlaag", inkomhal);
        
        terras.setExit("zuidwest", troonzaal);
        terras.setExit("west", slaapzaal);
        
        kerkers.setExit("zuid", martelkamer);
        kerkers.setExit("omhoog", inkomhal);
        
        krot.setExit("noord", bordeel);
        krot.setExit("oost", start);
        
        martelkamer.setExit("noord", kerkers);
        
        slaapzaal.setExit("zuid", troonzaal);
        slaapzaal.setExit("oost", terras);
        
        // activeer teleport
        krot.setTelePoort(martelkamer, slaapzaal);
        martelkamer.setTelePoort(krot, slaapzaal);
        slaapzaal.setTelePoort(krot, martelkamer);
        
        // initialiseer vijanden
        dracula = new Vampier("Dracula");
        vijanden.add(dracula);
        dracula.setHuidigeKamer(kerkhof);
        lupos = new Weerwolf("Lupos");
        lupos.setHuidigeKamer(bordeel);
        vijanden.add(lupos);
        zombie = new Zombie("Supposed-To-Be-Dead");
        vijanden.add(zombie);
        zombie.setHuidigeKamer(sacristie);
        merlijn = new WitteTovenaar ("Merlijn");
        vijanden.add(merlijn);
        merlijn.setHuidigeKamer(lab);
        saruman = new ZwarteTovenaar ("Saruman");
        vijanden.add(saruman);
        saruman.setHuidigeKamer(terras);
        gandalf = new GrijzeTovenaar ("Gandalf");
        vijanden.add(gandalf);
        gandalf.setHuidigeKamer(taverne);
    }
    
    public Kamer GetStartPositie() {return start;}
    
// Map gerelateerde zaken
    /**
     * Een bepaalde kamer wordt opgevraagd aan de hand van zijn coördinaten.
     */
    public Kamer getKamer(int xPos, int yPos, int verdieping)
    {
        Kamer kamer = null;
        for (Iterator iter = kamers.iterator(); iter.hasNext();) {
            Kamer i = (Kamer)iter.next();
            if (i.getXPos() == xPos && i.getYPos() == yPos && i.getVerdieping() == verdieping)
            {kamer = i;}
        }
        return kamer;
    }
    /**
     * De ArrayList met de verschillende deur objecten wordt doorgegeven aan de klasse Map.
     */
    public ArrayList getDeuren()
    {
        ArrayList arraylist = (ArrayList) deuren.clone();
        return arraylist;
    }
    /**
     * De ArrayList met de verschillende vijand objecten wordt doorgegeven aan de klasse Map.
     */
    public ArrayList getVijanden()
    {
        ArrayList arraylist = (ArrayList) vijanden.clone();
        return arraylist;
    }
    
// Deur gerelateerde zaken
    /**
     * Controleert of een bepaalde deur open is.
     */
    public boolean deurOpen(Kamer kamer, String dir)
    {
        boolean open = true;
        
        for (Iterator iter = deuren.iterator(); iter.hasNext();) {
            Deuren deur = (Deuren)iter.next();
            boolean deurAanwezig = deur.deurAanwezig(kamer, dir);
            if (deurAanwezig == true) {open = false;}
        }
        return open;
    }
    public Deuren getDeur(Kamer kamer)
    {
        Deuren deur = null;
        for (Iterator iter = deuren.iterator(); iter.hasNext();) {
            Deuren door = (Deuren)iter.next();
            boolean deurAanwezig = door.deurAanwezig(kamer);
                if (deurAanwezig == true) {deur = door;}
        }
        return deur;
    }
    public String tekstDeur(Kamer kamer)
    {
        String tekstDeur = "";
        for (Iterator iter = deuren.iterator(); iter.hasNext();) {
            Deuren deur = (Deuren)iter.next();
            if (deur.deurAanwezig(kamer) == true) {tekstDeur += deur.tekstDeur(kamer) + ".\n";}
        }
        return tekstDeur;
    }
    public void openDeur(int nummerSleutel, Deuren deur) {deur.openDeur(nummerSleutel);}
    
    public void klopDeur(Deuren deur) {deur.molesteerDeur();}
    
    public void schietDeur(Deuren deur) {deur.schietDeur();}
    
// Vijand gerelateerde zaken
    public Vijanden getVijand(Kamer kamer)
    {
        for (Iterator iter = vijanden.iterator(); iter.hasNext();) {
            Vijanden vijand = (Vijanden)iter.next();
            if (vijand.getHuidigeKamer() == kamer) {return vijand;}
        }
        return null;
    }
    public void getVijandString(Kamer kamer) {
        Vijanden vijand = getVijand(kamer);
        System.out.println("Vijanden: " + vijand.getDescription() + " (" + vijand.getEnergie() + " HP)");
    }
    
    public void ontmoetenVijand(Vijanden vijand, Speler speler) {vijand.ontmoeten(speler);}

    public void aanval(Kamer kamer, Speler speler, Vijanden vijand)
    {
        while (speler.isLevend() && vijand.isLevend()) {
            vijandAanvallen(vijand, speler);
            aanvallenVijand(vijand, speler);  // De vijand valt automatisch terug aan
        }
        if (vijand.isLevend() == false)
            vijanden.remove(vijand);
        if (!speler.isLevend()) {
            System.out.println();
            System.out.println("U sterft een vrede en langzame dood!");
        }
    }
    private void vijandAanvallen(Vijanden vijand, Speler speler)
    {
        float krachtOntvangenMep = speler.aanvallen(speler.getKrachtAanvalswapen());
        float echteSchade = vijand.verdedigen(krachtOntvangenMep, vijand.getKrachtVerdedigingsWapen());
        vijand.wijzigEnergie(-echteSchade);
        System.out.println(vijand.getDescription() + " verliest " + echteSchade + " Hp");
    }
    private void aanvallenVijand(Vijanden vijand, Speler speler)
    {
        float krachtOntvangenMep = vijand.aanvallen(vijand.getKrachtAanvalswapen());
        float echteSchade = speler.verdedigen(krachtOntvangenMep, speler.getKrachtVerdedigingsWapen());
        System.out.println(speler.getName() + " verliest " + echteSchade + " Hp");
        speler.wijzigEnergie(-echteSchade);
    }
    public void beweegVijanden()
    {
        ArrayList uitgangen = new ArrayList();
        for (Iterator iter = vijanden.iterator(); iter.hasNext();) {
            uitgangen.clear();
            Vijanden vijand = (Vijanden) iter.next();
            Kamer kamer = vijand.getHuidigeKamer();
            StringTokenizer tokenizer = new StringTokenizer(kamer.getExitString());
            while (tokenizer.hasMoreTokens()) {uitgangen.add(tokenizer.nextToken());}
            int nummer = random.nextInt(uitgangen.size());
            String uitgang = (String) uitgangen.get(nummer);
            Kamer volgendeKamer = vijand.getHuidigeKamer().getExit(uitgang);
            vijand.setHuidigeKamer(volgendeKamer);
        }
    }
}