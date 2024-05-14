
/**
 * This is prisoner's dilemma! A game theory experiment to explore a situation
 * in which two people are seperated and unable to communicate and are forced to
 * choose between working with or against each other
 *
 * @Louis Turnidge
 * @15/05/2024
 */
import java.util.Random;
import java.util.Scanner;
public class MyGame
{
 public static void main(String[] args){                                             
   Scanner keyboard = new Scanner(System.in); 
     
     
 System.out.println("Hello and welcome to Prisoner's dilemma!");
 System.out.println("The purpose of this game is to explore how may two people will act seperated, either cooperating or bertraying.");
 System.out.println("How to play: You will be given a sceanario in which you are asked to rat out your opponent of a crime,");
 System.out.println("You then get to type in your choice to either stay silent or betray your friend. Once you've given an answer, your opponent will give their answer in return.");
 System.out.println("Your opponent's choice will determine how long you both spend in prison. Whoever serves the least years, wins the rounds!");
 System.out.println(""); 
 
 String[] answer ={"He's innocent!", "He's guilty!"};
 String[] reply ={"Is that right?", "Thank you for cooperating"};
 
 System.out.println("Reply chocies");
 
 for(int i=0; i < answer.length; i++){
        System.out.println(answer[i]);
      
    }
 
 System.out.println("Hello, your friend is suspected of murder! Did he do it?!");       
 String entered = keyboard.nextLine();   
 
 
 
   for(int i=0; i < answer.length; i++){
        if (entered.equals(answer[i]))
            System.out.println(reply[i]);
    }
        
        
        
        
    }
}
