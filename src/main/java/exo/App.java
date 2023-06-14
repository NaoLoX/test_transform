package exo;

/**
 * Hello world!
 *
 */
public class App 
{

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
        String transformedText = textTransformer.Transform(text);
        System.out.println(transformedText);
    }
}
