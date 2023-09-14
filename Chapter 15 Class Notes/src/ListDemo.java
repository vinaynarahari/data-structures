import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /*The add last method can populate a list */

        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        /* the List is currently tnpg */

        /*
         * The list iterator method creates a new list iterator that is postioned at the head of the list
         * The "|" to represent the iterator position
         */

        ListIterator<String> iterator = staff.listIterator(); // |TNPG -- iterator at start of list

        /* The next methhod advances the iterator over the next element in the list */
        iterator.next(); // T|NPG -- iterator between tony and natasha nodes

        /* The next method also returns the element that the iterator is passing */

        String avenger = iterator.next(); // TN|PG -- iterator between natasha and peter
        System.out.print(avenger); // will print out natasha 

        // add method inserts method at iterator position
        // Iterator is then positioned AFTER the element that was added 
        iterator.add("Buce "); // TNBPG -- bruce is added in between natasha and peter b/c thats where iterator is 
        iterator.add("Rocket"); // TNBRPG -- iterator was moved after bruce before meaning that add moves iterator after the item that you added


        /* The remove method for iterators removes the element returned by the last call to next or previous 
         * the remove method can only be called after calling next or previous
         * remove method CANNOT be called after calling add
         */

        iterator.next(); //TNBRP|G
        iterator.remove(); //Removes peter  so the new linked list is TNBR|G
        System.out.println(staff);


        /* The set method updates the element returned by the last call to next or previous
         */

         iterator.previous();
         iterator.set("Scott");// TNB|SG -- rocket gets changed to scott 

         /* The hasNext method is used to determmine if there is a next node. Often used in the condition of a while loop */

         



    }
}
