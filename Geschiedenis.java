import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;

public class Geschiedenis
{
    private Stack kamers, levenspeler, itemsspeler, itemskamer, spelers, stackdeuren, hpDeuren, stackvijanden, hpVijanden, kamerVijanden;
    private Wereld wereld;

    public Geschiedenis(Wereld wereld)
    {
        spelers = new Stack();
        kamers = new Stack();
        levenspeler = new Stack();
        itemsspeler = new Stack();
        itemskamer = new Stack();
        stackdeuren = new Stack();
        hpDeuren = new Stack();
        stackvijanden = new Stack();
        hpVijanden = new Stack();
        kamerVijanden = new Stack();
        this.wereld = wereld;
    }

    public void slaOp(Speler speler)
    {
        Kamer kamer = speler.getHuidigeKamer();
        Float life = new Float(speler.getEnergie());
        spelers.push(speler);
        kamers.push(kamer);
        levenspeler.push(life);
        itemsspeler.push(speler.getItemsArrayList());
        itemskamer.push(kamer.getItemsArrayList());
        
        ArrayList deuren = wereld.getDeuren();
        
        for (Iterator iter = deuren.iterator(); iter.hasNext();) {
            Deuren deur = (Deuren)iter.next();
            Float hpDeur = new Float(deur.getHpDeur());
            stackdeuren.push(deur);
            hpDeuren.push(hpDeur);
        }
        
        ArrayList vijanden = wereld.getVijanden();
        
        for (Iterator iter = vijanden.iterator(); iter.hasNext();) {
            Vijanden vijand = (Vijanden) iter.next();
            Float hpVijand = new Float (vijand.getEnergie());
            stackvijanden.push(vijand);
            hpVijanden.push(hpVijand);
            kamerVijanden.push(vijand.getHuidigeKamer());
        }
    }
    
    public boolean goBack(int aantalSpelers)
    {
        boolean result = true;
        
        for(int i = 0; i < aantalSpelers; i++) {
            if(kamers.isEmpty()) {result = false;}
            else {
                Speler speler = (Speler) spelers.pop();
                Kamer kamer = (Kamer) kamers.pop();
                ArrayList itemsinspeler = (ArrayList) itemsspeler.pop();
                ArrayList itemsinkamer = (ArrayList) itemskamer.pop();
                Float life = (Float) levenspeler.pop();
                float leven = (float) life.floatValue();
                
                kamer.setItemsArrayList(itemsinkamer);
                speler.setItemsArrayList(itemsinspeler);
                speler.setHuidigeKamer(kamer);
                speler.setEnergie(leven);
                
                ArrayList deuren = wereld.getDeuren();

                for (int j = 0; j < deuren.size(); j++)
                {
                    Deuren deur = (Deuren) stackdeuren.pop();
                    Float lifeDeur = (Float) hpDeuren.pop();
                    int hpDeur = (int) lifeDeur.intValue();
                    deur.setHpDeur(hpDeur);
                }
                
                ArrayList vijanden = wereld.getVijanden();

                for (int k = 0; k < vijanden.size(); k++)
                {
                    Vijanden vijand = (Vijanden) stackvijanden.pop();
                    Float lifeVijand = (Float) hpVijanden.pop();
                    float hpVijand = (float) lifeVijand.floatValue();
                    vijand.setEnergie(hpVijand);
                    Kamer hier = (Kamer) kamerVijanden.pop();
                    vijand.setHuidigeKamer(hier);
                }
            }
        }
        return result;
    }
}
