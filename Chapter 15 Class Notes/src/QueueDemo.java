import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a print queue of strings (using linked lists)
        Queue<String> jobs = new LinkedList<>();
        jobs.add("Joe: Quarter to Expense Report");
        jobs.add("Marron: BMC Review");
        System.out.println("Printing: " + jobs.remove());
        jobs.add("Cathy: Really top secret document");
        jobs.add("Joe: Grocery list");
        jobs.add("Cathy: Can I get fired for this?");
        System.out.println("Printing: " + jobs.remove());
        jobs.add("Boss: Cathy termination letter");

        // How to print the rest of the jobs in the queue

        for(int i = 0; i<jobs.size(); i++){
            System.out.println("Printing: " + jobs.remove());
        }
    }
}
