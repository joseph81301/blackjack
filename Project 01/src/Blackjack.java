import java.util.Random;
import java.util.Scanner;
import java.util.jar.JarEntry;

public class Blackjack {

    public static void main(String[] args) {
        /* Declaring variables, including the random variable.  */
        P1Random randomGen = new P1Random();
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        int gameNumber = 1;
        int userWin = 0;
        int dealerWin = 0;
        int tieGame = 0;

        //Setting a loop, making it so that the program repeats everything inside until the player exits by pressing 4
        while (userChoice != 4) {
            int userHand = 0;
            int dealerHand = 0;

            // Creating the random number and setting it inside the userCard variable
            int userCard = randomGen.nextInt(13) + 1;

            System.out.println();
            System.out.println("START GAME #" + gameNumber +"\n");

            //Making if else statements to check if the card is a 1, 11, 12, or 13 and changing the name to Jack or King or Ace, etc
            if (userCard < 11)  {
                if (userCard == 1) {
                    System.out.println("Your card is a ACE!");
                }
                else {
                    System.out.println("Your card is a " + userCard + "!");
                }
                userHand = userHand + userCard;
                System.out.println("Your hand is: " + userHand);
                System.out.println();
            }
            else if (userCard == 11) {
                userCard = 10;
                userHand = userHand + userCard;
                System.out.println("Your card is a JACK!");
                System.out.println("Your hand is: " + userHand);
                System.out.println();
            }
            //continuing to change to Jack, King, Queen, etc
            else if (userCard == 12) {
                userCard = 10;
                userHand = userHand + userCard;
                System.out.println("Your card is a QUEEN!");
                System.out.println("Your hand is: " + userHand);
                System.out.println();
            }
            else if (userCard == 13) {
                userCard = 10;
                userHand = userHand + userCard;
                System.out.println("Your card is a KING!");
                System.out.println("Your hand is: " + userHand);
                System.out.println();
            }

            // Loops the program again so that the different games can start
            while (userChoice != 4) {

                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit \n");
                System.out.print("Choose an option: ");

                userChoice = scanner.nextInt();

                // If else statements to produce different outputs depending on the player's input such as 1 2 3 or 4
                if (userChoice == 1) {
                    System.out.println();

                    userCard = randomGen.nextInt(13) + 1;

                    if (userCard < 11)  {
                        if (userCard == 1) {
                            System.out.println("Your card is a ACE!");
                        }
                        else {
                            System.out.println("Your card is a " + userCard + "!");
                        }
                        userHand = userHand + userCard;
                        System.out.println("Your hand is: " + userHand);
                        System.out.println();
                    }
                    //again changing 11 12 13 or 1 to Ace King etc
                    else if (userCard == 11) {
                        userCard = 10;
                        userHand = userHand + userCard;
                        System.out.println("Your card is a JACK!");
                        System.out.println("Your hand is: " + userHand);
                        System.out.println();
                    }
                    else if (userCard == 12) {
                        userCard = 10;
                        userHand = userHand + userCard;
                        System.out.println("Your card is a QUEEN!");
                        System.out.println("Your hand is: " + userHand);
                        System.out.println();
                    }
                    else if (userCard == 13) {
                        userCard = 10;
                        userHand = userHand + userCard;
                        System.out.println("Your card is a KING!");
                        System.out.println("Your hand is: " + userHand);
                        System.out.println();
                    }
                    //Setting conditions for the player to win or lose
                    if (userHand == 21) {
                        System.out.println();
                        System.out.println("BLACKJACK! You win!");
                        System.out.println();
                        gameNumber++;
                        userWin++;
                        break;
                    }
                    else if (userHand > 21) {
                        System.out.println();
                        System.out.println("You exceeded 21! You lose.");
                        System.out.println();
                        gameNumber++;
                        dealerWin++;
                        break;
                    }
                }
                // Setting conditions for the dealer to win or lose when player selects to hold
                else if (userChoice == 2) {
                    dealerHand = randomGen.nextInt(11) + 16;
                    System.out.println();
                    System.out.println("Dealer's hand: " + dealerHand);

                    System.out.println("Your hand is: " + userHand);

                    if (dealerHand > 21) {
                        System.out.println();
                        System.out.println("You win!");
                        System.out.println();
                        userWin++;
                        gameNumber++;
                        break;
                    }
                    else if (dealerHand == userHand) {
                        System.out.println();
                        System.out.println("It's a tie! No one wins!");
                        System.out.println();
                        tieGame++;
                        gameNumber++;
                        break;
                    }
                    //The break is so that once the dealer wins/loses, it kicks out of this loop and goes to the first loop
                    // to start the next game
                    else if (dealerHand == 21) {
                        System.out.println();
                        System.out.println("Dealer wins!");
                        System.out.println();
                        dealerWin++;
                        gameNumber++;
                        break;

                    }
                    else if (dealerHand > userHand) {
                        System.out.println();
                        System.out.println("Dealer wins!");
                        System.out.println();
                        dealerWin++;
                        gameNumber++;
                        break;
                    }
                    else if (userHand > dealerHand) {
                        System.out.println();
                        System.out.println("You win!");
                        System.out.println();
                        userWin++;
                        gameNumber++;
                        break;
                    }

                }
                //Shows the statistics of the player
                else if (userChoice == 3) {
                    System.out.println();
                    System.out.println("Number of Player wins: " + userWin);
                    System.out.println("Number of Dealer wins: " + dealerWin);
                    System.out.println("Number of tie games: " + tieGame);
                    System.out.println("Total # of games played is: " + (gameNumber -1));
                    double playerWins = userWin * 100.0 / (gameNumber - 1) ;
                    System.out.println("Percentage of Player wins: " + playerWins + "% \n");


                }
                //checking to see if the player inputs something other than 1 2 3 or 4 and saying hey you cant do that, try again
                else if (userChoice > 4 || userChoice < 1) {
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");


                }

            }
        }
    }
}