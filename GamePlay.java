import java.util.*;
import java.io.*;
/**
 * This class has the main( ) method to 
 * play the simple hang mane game.
 * The phrase to guess is hard-coded. You
 * will change this code to read the phrase from a 
 * text data file.
 * 
 * @author R. Shiroya
 * @version v1
 */
public class GamePlay
{
   public static void main(String[ ] args)
   {
       Scanner in = new Scanner(System.in);
       char guess;
       
       System.out.println("Welcome!");
       System.out.println("1. North American Countries.");
       System.out.println("2. North American Rivers.");
       System.out.println("3. North American Cities.");
       System.out.println("4. Oscar Movies.");
       System.out.println("5. Pop Artists.");
       System.out.print("Please Select one from the categories. Enter Number 1 - 5: ");
       int category = in.nextInt();
       
    {
       Random rng = new Random();
       int number;
       number = rng.nextInt(5) +  1;
       
       GameWord myPhrase = new GameWord("one day at a time" );
       
       boolean [ ] used = new boolean[255];
       
       
       System.out.println("\n" + myPhrase.toString( ));
       while(!myPhrase.checkWin( ) && ! myPhrase.getGameOver( ))
       {
         do{
           System.out.print("\nEnter your character: ");
           guess = in.nextLine( ).charAt(0);
           
           
           
           if(used[guess]) System.out.println("That letter already guessed.");
        }while (used[guess]);
         used[guess] = true; 
         myPhrase.find(guess);
         System.out.println("\n" + myPhrase.toString( ));
       }
    
       if(myPhrase.checkWin( ))
       {
         System.out.println("You got it!");
       }
        
       System.out.println("Game Over");  
       System.out.println("Game Over"); 
       System.out.println("Game Over"); 
       System.out.println("Game Over"); 
    }
}
}
