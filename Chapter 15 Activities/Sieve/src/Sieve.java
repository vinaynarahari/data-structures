import java.util.Scanner;
import java.util.Set;
import java.util.Set;
import java.util.*;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set <Integer> numbers = new HashSet<>();
        for(int i =2; i<=n; i++){
            numbers.add(i);
        }
        

        for(int x = 2; x<= n; x++){
            for(int y = 0; y<= n; y++){
                if(y%x == 0 & x!= y){
                    numbers.remove(y);
                }
            }
        }
        System.out.println(numbers);





    }
}
