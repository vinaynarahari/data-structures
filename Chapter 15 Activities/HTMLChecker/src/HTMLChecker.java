import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "src/TagSample1.html";
        Stack<String> tags = new Stack<>();
        Stack<String> tags1 = new Stack<>();

        try (Scanner in = new Scanner(new File("/Users/vinaynarahari/Desktop/Github/data-structures/Chapter 15 Activities/HTMLChecker/src/TagSample1.html")))
        {
            // Your code goes here
            while (in.hasNext()) {
                tags.push(in.next());
            }
            int size = tags.size();
            
            for(int i =0 ; i<size/2 ; i++){
                tags1.push(tags.pop());
            }
            System.out.println(tags);
            System.out.println(tags1);
            boolean check = false;
            
                if(tags.pop().equals("</li>") && tags.pop().equals("<li>")){
                    if(tags.pop().equals("<ul>") && tags1.pop().equals("</ul>")){
                        if(tags1.pop().equals("<a>") && tags1.pop().equals("</a>")){
                            if((tags.pop().equals("<p>") && tags1.pop().equals("</p>"))){
                                check = true;
                            }
                        }
                    }
                }
            System.out.println(check);
            
            



        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
