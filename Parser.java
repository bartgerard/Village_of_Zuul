import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */

public class Parser 
{
    private Woorden commands;  // holds all valid command words

    public Parser() 
    {
        commands = new Woorden();
    }

    public Command getCommand(String gameFase) 
    {        
        String inputLine = "";   // will hold the full input line
        String word1;
        String word2;
        String word3;

        System.out.print("> ");     // print prompt
        
        inputLine = LeesTekst();

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;
        if(tokenizer.hasMoreTokens())
            word3 = tokenizer.nextToken();      // get derde woord
        else
            word3 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        if(commands.isCommando(word1, gameFase))
            return new Command(word1, word2, word3);
        else
            return new Command(null, word2, word3);
    }

    /**
     * Print out a list of valid command words.
     */
    public void showCommands(String gameFase)
    {
        System.out.println(commands.toonAlles(gameFase));
    }
    
    public String LeesTekst()
    {
        String inputLine = "";
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {inputLine = reader.readLine();}
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: " + exc.getMessage());
        }
        return inputLine;
    }
}