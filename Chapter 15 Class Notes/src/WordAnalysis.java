import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        // Read the dictionary and the novel
        Set <String> dictionaryWords = readWords("Chapter 15 Class Notes\\src\\words");
        Set <String> novelWords = readWords("Chapter 15 Class Notes\\src\\war-and-peace.txt");

        // print all the words that are in the novel but not in the dictionary

        for(String word: novelWords) {
            if(!dictionaryWords.contains(word)){
                System.out.println(word);
            }
        }

        //print unique words in the novel
        System.out.println("There are " + novelWords.size() + " in the novel");

        // print numbre of unqiue words with greater than 3 words
        Iterator <String> iterator = novelWords.iterator();

        while(iterator.hasNext()){
            if(iterator.next().length() > 3){
                iterator.remove();
            }
        }
    }


    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        // using hashset instead of treeset because order doesnt matter
        Set <String> words = new HashSet<>();

        // determine the current working directory
        System.out.println(System.getProperty("user.dir"));


        Scanner scanner = new Scanner(System.in, "UTF-8");

        // use any charecter thats not a letter as delimeters
        scanner.useDelimiter("[^a-zA-Z]+");

        while(scanner.hasNext()){
            // add words tp the set and by default the dupilcates are ignored
            words.add(scanner.next().toLowerCase());
        }
        return words;
    }
}
