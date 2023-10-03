import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.text.Style;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo 
{
    public static void main(String[] args)
    {
        // workorder class has priority and description
        Queue<WorkOrder> toDo = new PriorityQueue<>();
        toDo.add(new WorkOrder(3, "Water Plants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(2, "Garden"));
        toDo.add(new WorkOrder(9, "Play Videogames"));
        toDo.add(new WorkOrder(1, "Study for Chapter 15 Test"));

        //Objects are not stored in prioirty order
        System.out.println(toDo);

        // if you do remove though objects will be removed in priority order

        while(toDo.size() > 0){
            System.out.println(toDo.remove());
        }
    }
}
