import java.util.Random;

public class Beker extends Item
{
    private String soort;
    private boolean winnenMogelijk;
    
    public Beker(String description, int gewicht, int getal)
    {
        super(description, gewicht, getal);
        
        Random random = new Random();
        
        float i = random.nextFloat();
        
        if (i <= 0.36) {
            soort = "de beker van het succes";
            winnenMogelijk = true; }
        if (i >= 0.64) {
            soort = "een beker met stof";
            winnenMogelijk = false; }
        if (i > 0.36 && i < 0.64) {
            soort = "een beker met wijn";
            winnenMogelijk = false; }
    }
    
    public void winnen()
    {
        System.out.println();
        System.out.println("U vond " + soort);
        if (winnenMogelijk == true) {System.out.println("Proficiat U heeft gewonnen");}
        if (winnenMogelijk == false) {
            System.out.println("Helaas, de Goden waren U niet gunstig gezind.");
            System.out.println("Misschien volgende keer meer geluk!");
        }
    }
    
    public String gebruik() {return "win";}
    
    public int getKrachtVerdedigingsWapen() {return 0;}
    
    public int getKrachtAanvalsWapen() {return 0;}
}