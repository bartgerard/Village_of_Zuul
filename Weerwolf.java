/**
 * Weerwolven klauwen naar de held. De gevolgen voor de energie
 * is afhankelijk van de lengte van de klauwen, namelijk 2 energiepunten per
 * centimeter klauw. Volwassen weerwolven hebben klauwen van minstens 5
 * centimeter, kleintjes zijn schattig en hebben mini-klauwtjes van maximaal
 * 2 centimeter.
 */
public class Weerwolf extends Vijanden
{
    private int lengteKlauw;
    
    public Weerwolf(String description)
    {
        super(description);
        
        boolean volwassen;
        volwassen = random.nextBoolean();
        
        if (volwassen == true) {
            int maxLengteKlauwVolwassen = 15;
            int minLengteKlauwVolwassen = 5;
            lengteKlauw = minLengteKlauwVolwassen + random.nextInt(maxLengteKlauwVolwassen - 4);
        }
        else {
            int maxLengteKlauwKleintje = 2;
            lengteKlauw = random.nextInt(maxLengteKlauwKleintje + 1);
        }
    }
    
    public void ontmoeten(Speler speler)
    {
        speler.wijzigEnergie(-2 * lengteKlauw);
        System.out.println("De weerwolf zijn " + lengteKlauw + " cm lange klauw ontdoet U van " + 2 * lengteKlauw + " Hp.");
    }
}