import java.util.*;
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
         Map<String,String > gradeBook = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("What the name of the student?");
                String name = in.next();
                System.out.println("What the grade of the student?");
                String grade = in.next();
                gradeBook.put(name,grade);
            } else if (input.equals("R"))
            {
               System.out.println("What the name of the student?");
                String name = in.next();
                gradeBook.remove(name);
            } else if (input.equals("M"))
            {
                System.out.println("What the name of the student?");
                String name = in.next();
                System.out.println("What the grade of the student?");
                String grade = in.next();
                gradeBook.put(name,grade);
            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys  = gradeBook.keySet();
                ArrayList<String> arrayList = new ArrayList<>(keys);
                Collections.sort(arrayList);
                    
                System.out.println(arrayList);
                for(String name: arrayList){
                    System.out.println(name + ": " + gradeBook.get(name));
                }
            } else
            {
                done = true;
            }
        }
    }
}
