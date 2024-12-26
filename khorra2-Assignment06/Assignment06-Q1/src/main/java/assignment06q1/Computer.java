package assignment06q1;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Computer extends Player{

    public Computer(String name, char symbol) { 
        super(name, symbol); //retrieves name and symbol from superclass Player
    }

    @Override
    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in); 
        boolean validMove = false;
        int attempts = 0; //track number of attempts doesn't exceed the number of placements on the board
        while (!validMove && attempts < board.getSize() * board.getSize()) {
            System.out.print("Enter something (or press Enter to submit empty input):");
            String input = scanner.nextLine();
            if (input.isEmpty()) { //if a space is available to play
                int row = ThreadLocalRandom.current().nextInt(0, board.getSize()); //recieve a row/col number greater than 0, and including size of row/col
                int col = ThreadLocalRandom.current().nextInt(0, board.getSize());
                if (board.isCellEmpty(row, col)) {
                    board.updateBoard(row, col, getSymbol()); //placing the symbol at specific location
                    validMove = true; //break the loop
                }
                attempts++; //track attempts 
                 
                    System.out.println("The space you took is already filled, try again");
                
                
            } else {
                System.out.println("You entered: " + input + " try again");
            }
            
            
            }
            if (!validMove) { //if no valid move is made after exhausting all attempts
                System.out.println("No valid moves left for " + getName());
            }
        }
    }


