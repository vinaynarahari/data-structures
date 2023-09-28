import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        Map<String, Color> colors = new HashMap<>();

        // add eleemnts to a map by using the put method 

        colors.put("Peter", Color.BLACK);
        colors.put("Seth", Color.BLUE);
        colors.put("Celeste", Color.ORANGE);

        // two different keys can have the same value 

        colors.put("Dr.Miller", Color.ORANGE);

        // THe same key cannot have two different values
        // using put on a key that exists changes the value 
        colors.put("Peter", Color.YELLOW);
        
        //Create a set of the keys in a map
        // giving you a set of keys from the map in the set
        Set<String> keys  = colors.keySet();

        for(String key: keys){
            System.out.println(key + " ("+key.hashCode()+"): " + colors.get(key));
        }

        


    }
}
