import java.util.Random;

public class TelePoort extends Kamer
{
    private Random random;
    private Kamer kamer1, kamer2;
    
    /**
     * Constructor for objects of class Teleport
     */
    public TelePoort(String description, String naam, int xPos, int yPos, int verdieping)
    {
        super(description, naam, xPos, yPos, verdieping);
        random = new Random();
    }
    
    public void setTelePoort(Kamer kamer1, Kamer kamer2)
    {
        this.kamer1 = kamer1;
        this.kamer2 = kamer2;
    }
    
    public Kamer teleporteer(Kamer kamer)
    {
        float i = random.nextFloat();

        System.out.println();
        System.out.println("bla bla bla, je bent geteleporteerd");
        
        if (i <= 0.4)
            return kamer1;
        if (i > 0.4 && i <= 0.8)
            return kamer2;
        else
            return kamer;
    }
}