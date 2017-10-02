/**
 * Deze klasse houdt alle gekende commando's bij.
 * Het wordt gebruikt om deze commando's te laten herkennen als ze worden getypt.
 */
public class Woorden
{
    private static final String[] bestaandCommandoMenu = {"start","opties","legende","help","stop"};
    private static final String[] bestaandCommandoLegende = {"menu","help","stop"};
    private static final String[] bestaandCommandoOpties = {"spelers","beurten","menu","help","stop"};
    private static final String[] bestaandCommandoSpel = {"ga","terug","pakop","legneer","gebruik","vecht","map","help","stop"};
    
    /**
     * Constructor
     */
    public Woorden() {}
    
    /**
     * Controleer of een commando bestaat.
     * Geef true terug indien dit het geval is en false indien dit niet het geval is.
     */
    public boolean isCommando(String eenWoord, String gameFase)
    {
        if (gameFase.equals("menu")) {
            for (int i = 0; i < bestaandCommandoMenu.length; i++) {
                if (bestaandCommandoMenu[i].equals(eenWoord))
                    return true;
        }}
        if (gameFase.equals("legende")) {
            for (int i = 0; i < bestaandCommandoLegende.length; i++) {
                if (bestaandCommandoLegende[i].equals(eenWoord))
                    return true;
        }}
        if (gameFase.equals("opties")) {
            for (int i = 0; i < bestaandCommandoOpties.length; i++) {
                if (bestaandCommandoOpties[i].equals(eenWoord))
                    return true;
        }}
        if (gameFase.equals("spel")) {
            for (int i = 0; i < bestaandCommandoSpel.length; i++) {
                if (bestaandCommandoSpel[i].equals(eenWoord))
                    return true;
        }}
        return false;
    }
    
    /**
     * Geeft alle mogelijke commando's weer binnen de huidige fase van de game.
     */
    public String toonAlles(String gameFase)
    {
        String resultaat = "";
        if (gameFase.equals("menu")) {
            for (int i = 0; i < bestaandCommandoMenu.length; i++) {
                resultaat += bestaandCommandoMenu[i] + " ";
        }}
        if (gameFase.equals("legende")) {
            for (int i = 0; i < bestaandCommandoLegende.length; i++) {
                resultaat += bestaandCommandoLegende[i] + " ";
        }}
        if (gameFase.equals("opties")) {
            for (int i = 0; i < bestaandCommandoOpties.length; i++) {
                resultaat += bestaandCommandoOpties[i] + " ";
        }}
        if (gameFase.equals("spel")) {
            for (int i = 0; i < bestaandCommandoSpel.length; i++) {
                resultaat += bestaandCommandoSpel[i] + " ";
        }}
        return resultaat;
    }
}
