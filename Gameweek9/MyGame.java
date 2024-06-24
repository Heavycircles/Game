
/**
 * This is prisoner's dilemma! A game theory experiment to explore a situation
 * in which two people are seperated and unable to communicate and are forced to
 * choose between working with or against each other
 *
 * @Louis Turnidge
 * @19/06/2024
 */
import java.util.Random;
import java.util.Scanner;

public class MyGame
{
    public static void main(String[] args){                                            
        Scanner keyboard = new Scanner(System.in); 
        //Here I have a couple of integers which are related to the rounds
        //Specifically for generating the round points and genrating the number of rounds, set or random
        
        int rounds =0;
        int roundpoints = 0;

        String roundpoints_as_string = String.valueOf(roundpoints);
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
        rounds = getRounds();
        String[][] outcomes = new String[rounds][3];

        System.out.println("");
        //Here I've used a for loop to generate 10 rounds for the game to run. I set it by using a 2d Array and this for loop to
        //make the code run 10 times.
        for(int i=0; i < outcomes.length; i++){
            System.out.println("Type I for innocent and G for guilty");
            //Here I've used a string array to store the possible answers and replies to the question
            String[] answer ={"I!", "G!"};
            String[] reply ={"Is that right?", "Thank you for cooperating"};
            String Player ="";

            for(int j=0; j < answer.length; j++){
                System.out.println(answer[j]);

            }

            //Here I'ved used System.out.println to print out the main question of the game
            //I've also used keyboard input to allow the player to respond/type out answer
            System.out.println("Hello, your friend is suspected of murder! Did he do it?!");       
            String entered = keyboard.nextLine();   

            //I've used a for loop to connect different answers from the player to the response of the interogator. 
            //So for example if the player replies that his friend is guilty, the interogator will thank him
            //If he claims innocent he won't thank him and just say "is that right"
            for(int j=0; j < answer.length; j++){
                if (entered.equals(answer[j]))
                    System.out.println(reply[j]);
            }
            Player = entered;
            System.out.println("Alright I will now ask your friend if you're innocent or not");   

            String AIanswer = generateAnswer();//call getAnswer method
            System.out.println(AIanswer);  
            //This big chunk of code here consists of if and else statements. Its purpose is to take the player and opponents answers and form an outcome with them.
            //For example if both player and opponent say guilty, the computer will print out that they both must serve 2 years in prison.
            outcomes[i][0]= Player;
            outcomes[i][1]= AIanswer;

            if(Player.equals("G!") && AIanswer.equals("G!")){
                System.out.println("Both claim guilty! -3 points!"); 
                roundpoints = roundpoints - 3;
            } else if(Player.equals("I!") && AIanswer.equals("G!")){
                System.out.println("Friend says you're guilty! -5 points!");
                roundpoints = roundpoints - 5;
            }
            else if(Player.equals("I!") && AIanswer.equals("I!")){
                System.out.println("Both claim innocent! +1 point!");
                roundpoints = roundpoints + 1;
            } else { 
                if(Player.equals("G!") && AIanswer.equals("I!")){
                    System.out.println("You claim your friend is guilty! +2 points!");
                    roundpoints = roundpoints + 2;
                }
            } 

            outcomes[i][2]= String.valueOf(roundpoints);
        }  

        for(int i=0; i < outcomes.length; i++){
            System.out.println("Round " + i + " Player said  " + outcomes[i][0]);
            System.out.println("Round " + i + " Opponent said  " + outcomes[i][1]);
            System.out.println("Score: "  + outcomes[i][2]);
        }
        System.out.println("Final score is " + String.valueOf(roundpoints) + "!");
    }
    //Here is a method that consists of the Opponent/AIs code. I've used math.random to generate a random respone from the opponent, between innocent or guilty.
    public static String generateAnswer(){  

        String[] Opponent ={"I!", "G!"};  

        int myInt;
        //This whole chunk of code is the AI's choice. I've coded it so that 
        //the AI makes a random answer between innocent and guilty. 
        //I've done this by using an array of possible answers, then I used math.random to make the AI randomly choose an answer.
        Random random = new Random();
        myInt = random.nextInt(Opponent.length);
        return(Opponent[myInt]);
          

    }
    public static int getRounds(){
        Scanner keyboard = new Scanner(System.in); 
        Random random = new Random();
        int rounds =0;
        String question;
        System.out.println("Type 10 for 10 rounds, random for a random number of rounds"); 
        question = keyboard.nextLine();
        if (question.equals("10")){
            rounds = 10;
        }
        else if (question.equals("random")){
            rounds = random.nextInt(15);
        } 
        return(rounds);
        
    }

}
