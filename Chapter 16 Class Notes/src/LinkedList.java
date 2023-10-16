import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    /*
     * first variable refers to first node in the list
     * if list is empty,  first will be null
     */
    private Node first;

    public LinkedList(){
        this.first = null; // cuz the linked list empty
    }
    



    /**
        Constructs an empty linked list.
    */




    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getfirst() {
        if(this.first  == null){
            throw new  NoSuchElementException();
        }
            
        return this.first.data; 
    }




    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst(){
        if(this.first == null){
            throw new NoSuchElementException();
        }
        Object element = this.first.data;
        this.first = this.first.next;
        return element;
    }





    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */

    public void addFirst(Object add){
        Node newnode = new Node();
        newnode.data = add;
        newnode.next = this.first;
        this.first = newnode;
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */





    //Class Node
    static class Node {
        // static class because it doesnt need to access anything in linked list and isnt needed for anything else -- only used by linked lists
        // since this is an inner class the variables cant be accessed outside of the class anyways so public is okay
        public Object data;
        public Node next;


        


    }

    class LinkedListIterator implements ListIterator
    {
      //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */





        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */




    }//LinkedListIterator
}//LinkedList
