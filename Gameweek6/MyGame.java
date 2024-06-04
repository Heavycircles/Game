
/**
 * This is prisoner's dilemma! A game theory experiment to explore a situation
 * in which two people are seperated and unable to communicate and are forced to
 * choose between working with or against each other
 *
 * @Louis Turnidge
 * @22/05/2024
 */
import java.util.Random;
import java.util.Scanner;
public class MyGame
{
    public static void main(String[] args){                                            
        Scanner keyboard = new Scanner(System.in); 
        
        String[] Opponent ={"Friend says you're Guilty!", "Friend says you're innocent!"}; 

        //This code here is to set instructions for the player
        //explaining the game and how to play to them as to not cause confusion
        System.out.println("PRISONER'S DILEMMA");
        System.out.println("");
        System.out.println("Hello and welcome to Prisoner's dilemma!");
        System.out.println("The purpose of this game is to explore how may two people will act seperated, either cooperating or bertraying.");
        System.out.println("How to play: You will be given a sceanario in which you are asked to rat out your opponent of a crime,");
        System.out.println("You then get to type in your choice to either stay silent or betray your friend. Once you've given an answer, your opponent will give their answer in return.");
        System.out.println("Your opponent's choice will determine how long you both spend in prison. Whoever serves the least years, wins the rounds!");
        System.out.println("Type I for innocent and G for guilty"); 
        System.out.println("");

        //Here I've used a string array to store the possible answers and replies to the question
        String[] answer ={"I!", "G!"};
        String[] reply ={"Is that right?", "Thank you for cooperating"};
        String Player ="";
       
 
        for(int i=0; i < answer.length; i++){
            System.out.println(answer[i]);

        }

        //Here I'ved used System.out.println to print out the main question of the game
        //I've also used keyboard input to allow the player to respond/type out answer
        System.out.println("Hello, your friend is suspected of murder! Did he do it?!");       
        String entered = keyboard.nextLine();   

        //I've used a for loop to connect different answers from the player to the response of the interogator. 
        //So for example if the player replies that his friend is guilty, the interogator will thank him
        //If he claims innocent he won't thank him and just say "is that right"
        for(int i=0; i < answer.length; i++){
            if (entered.equals(answer[i]))
                System.out.println(reply[i]);
        }
        Player = entered;
        System.out.println("Alright I will now ask your friend if you're innocent or not");   
        
        String AIanswer = Generateanswer();//call getAnswer method
        System.out.println(AIanswer);  
        //This big chunk of code here consists of if and else statements. Its purpose is to take the player and opponents answers and form an outcome with them.
        //For example if both player and opponent say guilty, the computer will print out that they both must serve 2 years in prison.
        if(Player.equals("G!") && AIanswer.equals("G!")){
             System.out.println("Both guilty! Both go to prison for 2 years! You tie!");
            } else if(Player.equals("I!") && AIanswer.equals("G!")){
                System.out.println("You go to prison 3 years! Your friend goes 0! Opponent wins the round!");
            }
        else if(Player.equals("I!") && AIanswer.equals("I!")){
                System.out.println("Both claim innocent. Both go to prison 1 year! You tie!");
        
         } else { 
       if(Player.equals("G!") && AIanswer.equals("I!")){
              System.out.println("Your friend goes to prison 3 years! You go 0! You win the round!");
    }
         }
   
}


//Here is a method that consists of the Opponent/AIs code. I've used math.random to generate a random respone from the opponent, between innocent or guilty.
    public static String Generateanswer(){  

        String[] Opponent ={"I!", "G!"};  

        int myInt;
        //This whole chunk of code is the AI's choice. I've coded it so that 
        //the AI makes a random answer between innocent and guilty
        Random random = new Random();
        myInt = random.nextInt(Opponent.length);
        return(Opponent[myInt]);
        //main(Opponent[myInt]);   

        
    }

}
