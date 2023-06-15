package exo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger logger =Logger.getLogger("errorLogger");
    /**
     * the main function of the program
     * @param args the params when you start the jar program
     */
    public static void main( String[] args )
    {
        TextTransformer textTransformer =new TextTransformer();
        textTransformer.addToken("name","george");
        textTransformer.addToken("age", "26");
        String text = "Hello [name], vous avez [age] ans ";
        String transformedText = textTransformer.transform(text);
        logger.log(Level.INFO,transformedText);
    }
}
