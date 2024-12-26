package assignment06q1;

import java.util.Scanner;

public class Main {
     
    
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true; 
        while (playAgain) { 
            Player player1 = null;
            Player player2 = null; //initialize players 
            int boardSize = 3; // Default board size
            System.out.println("Welcome to Tic-Tac-Toe!");

            // Choose Player 1 Name and Symbol
            System.out.print("Enter Player 1 name: ");
            String name1 = scanner.nextLine().trim();
            char symbol1 = 'X';

            boolean validChoice = false;
            while (!validChoice) { 
                try {

                    // Choose Game Mode
                    System.out.println("\nChoose Game Mode:");
                    System.out.println("1. Human vs Human");
                    System.out.println("2. Human vs Computer");
                    System.out.println("3. Computer vs Computer");
                    System.out.print("Enter your choice (1, 2, or 3): ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume leftover newline

                    if (choice == 1) {
                        // Human vs Human
                        System.out.print("Enter Player 2 name: ");
                        String name2 = scanner.nextLine().trim();
                        char symbol2 = 'O';

                        player1 = new Human(name1, symbol1); //passes names and symbols to Player Human class 
                        player2 = new Human(name2, symbol2);
                        validChoice = true; //ends while loop
                    } else if (choice == 2) {
                        // Human vs Computer
                        System.out.println("Player 2 will be a Computer. Please press enter for auto generated placement.");
                        player1 = new Human(name1, symbol1);
                        player2 = new Computer("Computer", 'O');
                        validChoice = true;
                    } else if (choice == 3) {
                        // Computer vs Computer
                        System.out.println("Player 1 and Player 2 will both be Computers. Please press enter for auto generated placement.");
                        player1 = new Computer("Computer 1", symbol1);
                        player2 = new Computer("Computer 2", 'O');
                        validChoice = true;
                    } else if (choice < 1 || choice > 3) {
                        throw new IllegalArgumentException("Invalid game mode choice. Please restart the game.");
                    }

                    

                } catch (IllegalArgumentException e) { //recieives specific error
                    System.err.println("Error: " + e.getMessage());
                
                }
                catch (Exception e) {
                    // Handle general exceptions like invalid input for choice
                    System.err.println("Invalid input. Please enter a number (1, 2, or 3).");
                    scanner.nextLine(); // Clear invalid input
                }
            }
            // Start the game
            Game game = new Game(player1, player2, boardSize);
            game.startGame();
            // Ask if the user wants to restart
            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing!"); 
            }
        }
        
    }
    
}
