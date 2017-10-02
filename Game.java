import java.util.ArrayList;

/**
 *  Dit is de hoofdklasse van het spel "World of Zuul" 
 *  "World of Zuul" is een op tekst gebasseerd avonturen spel. 
 *  Spelers kunnen op zoek gaan naar de beker van El Pechos en onderweg vechten tegen meerdere paranormale wezens. 
 *  "It is extended and very interesting!"
 * 
 *  Om het spel te spelen, maak je een object aan van deze Klasse (Game) en roep de "play" methode op.
 * 
 * @author  Edo Franssen (A6) en Bart Gerard (A6)
 * @version 1.0 (Mei 2007)
 */

public class Game
{
    private Tekst tekst;
    private Parser parser;
    private Map map;
    private Speler speler;
    private Wereld wereld;
    private Geschiedenis geschiedenis;
    private int aantalSpelers, aantalBeurten, getal;
    private ArrayList spelers;
    private String gameFase; // Er zijn vier fases --> 1: Menu , 2: Legende, 3: Opties , 4: Spel
    private boolean klaar, volgendeBeurt;
        
    /**
     * Maak een game object aan.
     */
    public Game() 
    {
        parser = new Parser();
        tekst = new Tekst();
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play()
    {
        aantalSpelers = 1;
        aantalBeurten = 25;
        wereld = new Wereld();
        map = new Map(wereld);
        geschiedenis = new Geschiedenis(wereld);
        spelers = new ArrayList();
        klaar = false;
        gameFase = "menu";
        
        tekst.printWelcome();
        
        while (!klaar) {
            if (gameFase.equals("spel")) {
                for(int i = 0; i <= aantalSpelers && !klaar; i++) {
                    i = i % aantalSpelers;
                    
                    if (aantalSpelers > 1) {speler = (Speler)spelers.get(i);}

                    if (speler.isLevend()) {
                        
                        System.out.println();
                        System.out.println(speler.getName() + " is aan de beurt");
                        
                        Vijanden vijand = wereld.getVijand(speler.getHuidigeKamer());
                        if (vijand != null)
                            wereld.ontmoetenVijand(vijand, speler);
                            
                        for(volgendeBeurt = false; volgendeBeurt == false;)
                        {   
                            System.out.println(speler.getHuidigeKamer().getLongDescription());                    
                            System.out.println("Hp: " + speler.getEnergie());
                            
                            if (wereld.getVijand(speler.getHuidigeKamer()) != null) {wereld.getVijandString(speler.getHuidigeKamer());}
                            
                            System.out.println(wereld.tekstDeur(speler.getHuidigeKamer()));
                            
                            Command command = parser.getCommand(gameFase);
                            processCommand(command);
                        }
                    }
                    resterendeBeurten();
                    if (i == aantalSpelers - 1) {wereld.beweegVijanden();}
                }
            }
            else {
                Command command = parser.getCommand(gameFase);
                processCommand(command);
            }
        }
        System.out.println();
        System.out.println("Bedankt voor het spelen en tot ziens!");
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private void processCommand(Command command)
    {
        String commandWord = command.getCommandWord();
        
        if(command.isOngekend()) {
            System.out.println();
            System.out.println("Ik begrijp niet wat je bedoelt");
            System.out.println();
        }
        
        else if (commandWord.equals("help")) {tekst.printHelp(gameFase, parser);}
        
        else if (commandWord.equals("ga")) {goRoom(command);}
        
        else if (commandWord.equals("stop")) {
            klaar = true;
            volgendeBeurt = true;
        }
        else if(commandWord.equals("terug")) {goBack();}
            
        else if(commandWord.equals("pakop")) {
            geschiedenis.slaOp(speler);
            pickUp(command);
            volgendeBeurt = true;
        }
        else if(commandWord.equals("legneer")) {
            geschiedenis.slaOp(speler);
            drop(command);
            volgendeBeurt = true;
        }
        else if(commandWord.equals("start")) {
            gameFase = "spel";
            maakSpelersAan();
            aantalBeurten = aantalBeurten * aantalSpelers;
        }
        else if(commandWord.equals("legende")) {
            gameFase = "legende";
            tekst.legende(aantalBeurten);
        }
        else if(commandWord.equals("opties")) {
            gameFase = "opties";
            tekst.opties(aantalSpelers, aantalBeurten);
        }
        else if(commandWord.equals("menu")) {
            gameFase = "menu";
            tekst.printWelcome();
        }
        else if(commandWord.equals("spelers")) {
            aantalSpelers();
            tekst.printWelcome();
        }
        else if(commandWord.equals("beurten")) {
            aantalBeurten();
            tekst.printWelcome();
        }
        else if(commandWord.equals("map")) {
            Kamer kamer = speler.getHuidigeKamer();
            map.toon(kamer);
        }        
        else if(commandWord.equals("vecht")) {
            geschiedenis.slaOp(speler);
            Kamer kamer = speler.getHuidigeKamer();
            Float energieSpeler = new Float (speler.getEnergie());
            Vijanden vijand = wereld.getVijand(kamer);
            if (vijand != null) {
                wereld.aanval(kamer, speler, vijand);
                volgendeBeurt = true;
            }
        }
        else if(commandWord.equals("gebruik")) {gebruik(command);}
    }
    
    /**
     * Spelers worden aangemaakt en op hun startpositie neergezet.
     */
    private void maakSpelersAan()
    {
        Kamer start = wereld.GetStartPositie();
        
        for (int i = 0; i < aantalSpelers; i++) {
            System.out.println();
            System.out.println("Speler " + (i+1) + ", geef uw naam in");
            System.out.println();
            String naam = parser.LeesTekst();
            speler = new Speler(naam, start);
            spelers.add(speler);
        }
    }
    
// Wijzigingen in het optie menu
    /**
     * Aantal spelers wijzigen.
     */
    private void aantalSpelers()
    {
        System.out.println();
        System.out.println("Met hoeveel spelers wil U spelen ?");
        System.out.println();
        aantalSpelers  = nummerCheck();
        gameFase = "menu";
    }
    /**
     * Aantal beurten wijzigen
     */
    private void aantalBeurten()
    {
        System.out.println();
        System.out.println("Hoeveel beurten wil U het spel laten duren?");
        System.out.println();
        aantalBeurten = nummerCheck();
        gameFase = "menu";
    }
    /**
     * Controle of de ingetype string een numeriek waarde is.
     */
    private int nummerCheck()
    {        
        for(boolean nummer = false; nummer == false;) {
            try {
                getal = Integer.valueOf(parser.LeesTekst()).intValue();
                nummer = true;
            }
            catch(Exception exc) {
                System.out.println();
                System.out.println ("We verwachten een numerieke waarde !");
                System.out.println();
            }
        }
        return getal;
    }
    
// Voorwerp gerelateerde methodes.
    /**
     * Actie neerleggen van voorwerpen.
     */
    private void drop(Command command)
    {
        if (!command.hasSecondWord()) {System.out.println("Legneer Wat???");}
        else {
            String name = command.getSecondWord();
            Item i = speler.getItem(name);
            if(i == null) {System.out.println("Geen " + name + " in de rugzak");}
            else {
                speler.getHuidigeKamer().addItem(i);
                speler.removeItem(i);

            }
        }
    }
    /**
     * Actie oppakken van voorwerpen.
     */
    private void pickUp(Command command)
    {
        if (!command.hasSecondWord()) {System.out.println("Pakop Wat???");}
        else {
            String name=command.getSecondWord();
            Item i = speler.getHuidigeKamer().pickUp(name);
            if(i == null){System.out.println("Geen " + name + " in deze kamer");}
            else{
                if (speler.dragenMogelijk(i) == true) {
                    speler.addItem(i);
                    speler.getHuidigeKamer().removeItem(i);

                    if (i.gebruik().equals("win")) {i.winnen(); klaar = true;}
                }
            }
        }
    }
    /**
     * Actie gebruiken van voorwerpen.
     */
    private void gebruik(Command command)
    {
        if(!command.hasSecondWord()) {speler.getItemsString(); System.out.println();}
        else {
            geschiedenis.slaOp(speler);
            
            System.out.println();
            String naamItem = command.getSecondWord();
            
            if(!command.hasThirdWord()) {
                boolean inBezit = speler.gotItem(naamItem);
                
                if (inBezit == false) {System.out.println("Dit voorwerp steekt niet in uw rugzak!");}
                
                else {
                    Item item = speler.getItem(naamItem);
                    String actie = item.gebruik();
                    if (actie.equals("genees speler")) {
                        geneesSpeler(item);
                        volgendeBeurt = true;
                    }
                    else System.out.println("Naar waar?");
                }
            }
            else {
                String richting = command.getThirdWord();
                
                boolean inBezit = speler.gotItem(naamItem);
                
                if (inBezit == false)
                    System.out.println("Dit voorwerp steekt niet in uw rugzak!");
                else {
                    Item item = speler.getItem(naamItem);
                    String actie = item.gebruik();
                    
                    if (actie.equals("open deur")) {openDeur(item, richting);}
                    if (actie.equals("klop deur")) {klopDeur(richting);}
                    if (actie.equals("schiet deur")) {schietDeur(richting);}
                }
            }
        }
    }
    /**
     * Gebruik maken van sleutels om deuren te openen.
     */
    private void openDeur(Item item, String richting)
    {
        int nummerSleutel = item.getGetal();
        Kamer huidigeKamer = speler.getHuidigeKamer();
        Deuren deur = wereld.getDeur(huidigeKamer);
        if (deur == null) {System.out.println("Er staat hier geen deur");}
        if (wereld.deurOpen(huidigeKamer, richting)) {System.out.println("Deze deur is reeds open");}
        else {
            wereld.openDeur(nummerSleutel, deur);
            volgendeBeurt = true;
        }
    }
    /**
     * Gebruik maken van "melee" wapens om deuren te openen.
     */
    private void klopDeur (String richting)
    {
        Kamer huidigeKamer = speler.getHuidigeKamer();
        Deuren deur = wereld.getDeur(huidigeKamer);
        if (deur == null) {System.out.println("Er staat hier geen deur");}
        if (wereld.deurOpen(huidigeKamer, richting)) {System.out.println("Deze deur is reeds open");}
        else {
            wereld.klopDeur(deur);
            volgendeBeurt = true;
        }
    }
    /**
     * Gebruik maken van vuurwapens om deuren te openen.
     */
    private void schietDeur(String richting)
    {
        Kamer huidigeKamer = speler.getHuidigeKamer();
        Deuren deur = wereld.getDeur(huidigeKamer);
        if (deur == null) {System.out.println("Er staat hier geen deur");}
        if (wereld.deurOpen(huidigeKamer, richting)) {System.out.println("Deze deur is reeds open");}
        else {
            wereld.schietDeur(deur);
            volgendeBeurt = true;
        }
    }
    /**
     * Gebruik maken van energetische voorwerpen.
     */
    private void geneesSpeler(Item item)
    {
        speler.wijzigEnergie(item.getGetal());
        System.out.println("U gebruikte een " + item.getDescription() + " en kreeg zo " + item.getGetal() + " Hp bij");
        speler.removeItem(item);
    }
    
// Andere
    /**
     * Actie ongedaan maken.
     */
    private void goBack()
    {
        if(!geschiedenis.goBack(aantalSpelers)) {
            System.out.println();
            System.out.println("Kan niet terug, want bij de start");
        }
        else {
            aantalBeurten ++;
        }
        System.out.println();
        System.out.println(speler.getName() + " is aan de beurt");
    }

    /** 
     * Actie veranderen van ruimte.
     */
    private void goRoom(Command command) 
    {        
        if(!command.hasSecondWord()) {System.out.println("Waarheen?");}
        
        Kamer huidigeKamer = speler.getHuidigeKamer();

        String direction = command.getSecondWord();

        // Try to leave current room.
        Kamer volgendeKamer = speler.getHuidigeKamer().getExit(direction);
        
        if (volgendeKamer == null) {System.out.println("Daar is geen doorgang!");}
        
        else if (wereld.deurOpen(huidigeKamer, direction) == false) {System.out.println("Een deur verhindert uw pad");}
        
        else {
            geschiedenis.slaOp(speler);
            speler.gotoKamer(volgendeKamer);
            volgendeBeurt = true;
        }
    }
    
    /**
     * Methode die bepaalt wanneer de tijd op is.
     */
    private void resterendeBeurten()
    {
        aantalBeurten --;
        if (aantalBeurten == 0) {
            klaar = true;
            System.out.println();
            System.out.println("Helaas, uw tijd is verstreken");
        }
    }
}