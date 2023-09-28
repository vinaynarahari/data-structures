import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Business utility methods.
*/
public class Business
{
    /**
      * Removes every nth element from the linked list
      *
      * @param employeeNames the linked list to remove from
      * @param n                 the parameter to determine "nth"
     */
    public static void downsize(LinkedList<String> employeeNames, int n)
    {
        System.out.println(employeeNames.size());
        for(int i=0; i<employeeNames.size(); i++){
           
            if( (i+1) % n == 0 && i!=0){
                employeeNames.remove(i);
            }
        }



        /*int i =0;
         ListIterator<String> iterator = employeeNames.listIterator();
        while(iterator.hasNext()){
            i++;
            if(i == n ){
                iterator.remove();
                i =0;
            }
        }*/
    }
}
