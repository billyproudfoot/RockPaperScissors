
package rockpaperscissors;

import java.util.*;


public class RockPaperScissors {

    public static Scanner input = new Scanner(System.in);
    public static int rounds;   
    public static int shields;        
    public static int useShield;
    public static void main(String[] args) {
        
        gameSettings();
        
    }
 
    public static void gameSettings(){
        
        System.out.println("How many rounds would you like to play");
        rounds = input.nextInt(); 
        System.out.println("How many shields do you want(makes the round a tie if you were to lose)?");
        shields = input.nextInt();
        game();
    }
    
    public static void game(){
        int compScore=0;
        int userScore=0;
        for(int i=0; i<rounds; i++){
            boolean valid = false;
            while(valid==false){
            System.out.println("1.rock, 2.paper or 3.scissors?");
            int userChoice = input.nextInt();
            switch (userChoice){
                case 1:
                    valid=true;
                    break;
                case 2:
                    valid=true;
                    break;
                case 3:
                    valid=true;
                    break;
                default:
                    valid=false;
                    System.out.println("Invalid input, type either \"1\" \"2\" or \"3\" ");
            }
            Random rand = new Random();
            int compChoice = rand.nextInt((3-1)+1);
            useShield = 0;
            if (shields>0){
                System.out.println("Do you want to use a shield? Enter 1 for yes, 0 for no." + shields + " shields left. ");
               useShield = input.nextInt();
               if (useShield ==1){
                   shields--;
               }
            }
            if((userChoice==3&compChoice==2)|(userChoice==2&compChoice==1)|(userChoice==1&compChoice==3)){
                System.out.println("You won the round");
                userScore++;
            }else if((userChoice==compChoice)|useShield==1){
                System.out.println("You tied the round.");
            }else{
                System.out.println("You lost the round");
                compScore++;
        }
    }
        
}
        System.out.println("The game is over.");
        if (userScore>compScore){
            System.out.println("You won the game!");
        }else if (userScore==compScore){
            System.out.println("You drew the game!");
        }else if (userScore<compScore){
            System.out.println("You lost the game!");
}
        System.out.println("Would you like to play again? Enter yes or no.");
        String playAgain = input.next();
        if (playAgain.equals("yes")){
            gameSettings();
        }
    }
}