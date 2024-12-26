package assignment06q2;

import java.util.Scanner;

public class MainV2 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) { 
        Player player1 = null; //instance variable to hold player 1
        Player player2 = null;

        System.out.println("Welcome to Tic-Tac-Toe!");

        // Choose Player 1 Name and Symbol
        System.out.print("Enter Player 1 name: ");
        String name1 = scanner.nextLine().trim();
        char symbol1 = 'X';
        int boardSize = 0; //initialize board size 
        int winCondition = 0; //initialize win condition

        boolean validChoice = false; //loop for choosing game mode
        while (!validChoice) { 
            try {

                // Choose Game Mode
                System.out.println("\nChoose Game Mode:");
                System.out.println("1. Human vs Human");
                System.out.println("2. Human vs Computer");
                System.out.println("3. Computer vs Computer");
                System.out.print("Enter your choice (1, 2, or 3): ");
                int choice = scanner.nextInt();
                

                String name2 = "";
                char symbol2 = 'O';

                if (choice == 1) {
                    // Human vs Human
                    System.out.print("Enter Player 2 name: ");
                    name2 = scanner.nextLine().trim();
                    

                    player1 = new Human(name1, symbol1); //creating Human object for player1 and player2
                    player2 = new Human(name2, symbol2);
                    validChoice = true;
                } else if (choice == 2) {
                    // Human vs Computer
                    System.out.println("Player 2 will be a Computer. Please press enter for auto generated placement.");
                    player1 = new Human(name1, symbol1);
                    player2 = new Computer("Computer", symbol2);
                    validChoice = true;
                } else if (choice == 3) {
                    // Computer vs Computer
                    System.out.println("Player 1 and Player 2 will both be Computers. Please press enter for auto generated placement.");
                    player1 = new Computer("Computer 1", symbol1);
                    player2 = new Computer("Computer 2", symbol2);
                    validChoice = true;
                } else if (choice < 1 || choice > 3) { //invalid choice handling 
                    throw new IllegalArgumentException("Invalid game mode choice. Please restart the game.");
                }
                

            } catch (IllegalArgumentException e) { //catches specific error if they are not within range
                System.err.println("Error: " + e.getMessage());
               
            }
            
            catch (Exception e) {
                // catches general exceptions like invalid input for choice (#,character, string)
                System.err.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.nextLine(); // Clear invalid input
            }
            
    }
    // loop for choosing Board Size
    boolean validBoardSize = false;
    while (!validBoardSize) {
        try {
            System.out.println("Enter board size (3 <= N <= 20): ");
            boardSize = scanner.nextInt();
            scanner.nextLine(); // consume the leftover newline character

            if (boardSize < 3 || boardSize > 20) {//specific range must be met
                throw new IllegalArgumentException("Board size must be between 3 and 20.");
            }

            validBoardSize = true;
        } catch (IllegalArgumentException e) { //keeps prompting user until they input the correct value 
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter a valid board size.");
            scanner.nextLine(); // clear invalid input
        }
    }

    // Choose Winning Condition
    boolean validWinCondition = false;
    while (!validWinCondition) {
        try {
            System.out.println("Enter winning condition (number of markers in a straight line): ");
            winCondition = scanner.nextInt();
            scanner.nextLine(); // consume the leftover newline character

            if (winCondition <= 0 || winCondition > boardSize) { //must be within range and positive 
                throw new IllegalArgumentException("Winning condition must be a positive number and less than or equal to board size.");
            }

            validWinCondition = true;//condition is met
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Invalid input. Please enter a valid winning condition.");
            scanner.nextLine(); // clear invalid input
        }
    }

    GameV2 game = new GameV2(player1, player2, boardSize, winCondition); //initialize game with chosen settings
    game.startGame();
    System.out.println("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Goodbye.");
            }}

}
}
