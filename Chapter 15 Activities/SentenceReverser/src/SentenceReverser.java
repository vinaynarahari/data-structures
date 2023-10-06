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
    	int size  = 0;
        Stack<String> words = new Stack<>();
        while (scanner.hasNext()) {
            size++;
            String word = scanner.next();
            
            words.push(word);
            if(word.substring(word.length()-1, word.length()).equals(".")){
                for(int i = 0; i< size; i++){
                    System.out.println(words);
                    System.out.println(sentence1);
                    sentence1 =  sentence1 + words.pop() + " ";
                }
                sentence1= sentence1.substring(0, sentence1.length()-1) + ".";
                size = 0;
            
            }
        }

        
        int i = 0;
        int x = 1;

        for( int z = 0; z<2; z++){
            while(!sentence1.substring(i, x).equals(".")){
                
                i++;
                x++;
            }
            System.out.println(i + " ****** " + x);
            System.out.println(sentence1.substring(x +  1, sentence1.length()-1));
            sentence1 = sentence1.substring(0, i ) + " "+ sentence1.substring(x +  1, sentence1.length());
        }
        
        /*
        
         size = words.size();
        
        System.out.println(sentence1);

        for(int i = 0; i< size; i++){
            
            System.out.println(words);
            System.out.println(sentence1);
            sentence1 = sentence1 + words.pop() + " ";
        }*/

        return "list: " + sentence1;






    }
}
