
public class Tekst
{
    public Tekst() {}
    
    /**
     * Drukt een openingsbericht & startmenu af voor de speler.
     */
    public void printWelcome()
    {
        System.out.println();
        System.out.println(" VILLAGE OF ZUUL ");
        System.out.println();
        System.out.println("Typ 'start' om een spel te starten");
        System.out.println("Typ 'opties' om eventuele instellingen te wijzigen");
        System.out.println("Typ 'legende' als je de legende wilt aanhoren");
        System.out.println("Typ 'help' als je hulp nodig hebt");
        System.out.println("Typ 'stop' om het spel te verlaten");
        System.out.println();
    }
    
    /**
     * Drukt het verhaal en het doel van het spel af.
     */
    public void legende(int aantalBeurten)
    {        
        System.out.println();
        System.out.println("In een ver, ver verleden werd een dorpje vervloekt.");
        System.out.println("Het dorpje werd van alle menselijke kenmerken ontdaan.");
        System.out.println("Al wie het dorp betreedt, wordt onderhevig aan de vloek.");
        System.out.println("Enkel hij die tijdig de beker van succes kan bemachtigen, kan de vloek opheffen");
        System.out.println("en macht en rijkdom zullen hem ten deel vallen.");
        System.out.println("Hij die de verkeerde beker in handen krijgt, vernietigt de laatste kans op redding.");
        System.out.println("Zal jij de juiste vinden?");
        System.out.println();
        System.out.println("Baan je weg doorheen het dorp, maar let op!");
        System.out.println("Je hebt slechts " + aantalBeurten + " beurten alvorens de vloek je in zijn macht neemt.");
        System.out.println("Wees ondanks de tijdslimiet toch waakzaam voor eventuele gevaren.");
        System.out.println();
        System.out.println("Typ 'menu' om terug te keren naar het startvenster (en anders ook)");
        System.out.println();
    }
    
    /**
     * Drukt de opties af.
     */
    public void opties(int aantalSpelers, int aantalBeurten)
    {        
        System.out.println();
        System.out.println("Aantal spelers : " + aantalSpelers);
        System.out.println("Aantal beurten : " + aantalBeurten);
        System.out.println();
        System.out.println("Typ 'spelers' in om het aantal spelers te wijzigen");
        System.out.println("Typ 'beurten' in om het aantal beurten te wijzigen");
        System.out.println("Typ 'menu' om terug te keren naar het menu");
        System.out.println("Typ 'help' als je hulp nodig hebt");
        System.out.println("Typ 'stop' om het spel te verlaten");
        System.out.println();
    }
    
    /**
     * Drukt de mogelijke toetsencombinaties af.
     */
    public void printHelp(String gameFase, Parser parser) 
    {
        System.out.println();
        System.out.println("Mogelijke commando's zijn:");
        parser.showCommands(gameFase);
        System.out.println();
    }
}