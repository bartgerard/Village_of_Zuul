/**
 * - De Vampier -
 * Hij zuigt je half leeg met als gevolg dat je maar de helft
 * van je energie overhoudt. Heb je onderweg een teentje look opgeraapt,
 * dan heb je geluk, want vampieren gaan daarvan lopen en vallen je dus ook
 * niet aan. (In deze versie gaan ze dood)
 */
public class Vampier extends Vijanden
{
    private float wijziging;
    
    public Vampier(String description)
    {super(description);}
    
    public void ontmoeten(Speler speler)
    {
        if (speler.gotItem("look") == true) {System.out.println("De vampier laat U met rust.");}
        
        else {
            wijziging = speler.getEnergie()/2;
            speler.wijzigEnergie(-wijziging);
            wijzigEnergie(wijziging);
            System.out.println("De vampier grijpt naar uw nek en zuigt U half leeg");
        }
    }
}