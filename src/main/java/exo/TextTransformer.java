package exo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * a class who transform a text with the different token you set
 * @author bryan
 */
public class TextTransformer {
    private final HashMap<String, String> fields = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(TextTransformer.class);

    /**
     * add a token who have to be read to transform the text, can't be added if the taken already exist
     * @param name the key of the token
     * @param value the value of the token
     */
    public void addToken(String name, String value){
        if(this.fields.get(name) == null){
            this.fields.put(name,value);
        }
        else {
            logger.warn("Ce token existe déja");
        }
    }

    /**
     * take a text in input and transform the tokens into words, the token have to be between []
     * @param text the text you want to transform
     * @return the transformed text
     */
    public String transform(String text){
        int capacity = (int) (text.length() *1.2f);
        StringBuilder stringBuilder = new StringBuilder(capacity);
        Pattern pattern = Pattern.compile("\\[(.+?)\\]");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            String replacement = fields.get(matcher.group(1));
            if (replacement != null){
                matcher.appendReplacement(stringBuilder,"");
                stringBuilder.append(replacement);
            }
        }
        matcher.appendTail(stringBuilder);
        return stringBuilder.toString();
    }
}
