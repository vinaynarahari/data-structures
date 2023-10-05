import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
        String sentence1 = "";
    	Scanner scanner = new Scanner(sentence);
    	
        Stack<String> words = new Stack<>();
        while (scanner.hasNext()) {
            words.push(scanner.next());
        }
        int size = words.size();
        boolean bool = true;
        while(bool){
            if(words.pop().contains(".")){
                sentence1 = sentence1 + words.pop() + " ";
            }
        
        }
        System.out.println(sentence1);

        /*for(int i = 0; i< size; i++){
            
            System.out.println(words);
            System.out.println(sentence1);
            sentence1 = sentence1 + words.pop() + " ";
        }*/

        return sentence1;






    }
}
