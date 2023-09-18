import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        for(int i = strings.size()-1; i>=0; i--){
            String temp = strings.get(i);
            strings.addLast(temp);
            strings.remove(i);
        }
    }
}

// GHGHG|H