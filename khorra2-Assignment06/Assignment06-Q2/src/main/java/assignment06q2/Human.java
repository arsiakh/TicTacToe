package assignment06q2;

import java.util.Scanner;

public class Human extends Player {

    public Human(String name, char symbol) { 
        super(name, symbol);
    }
    @Override
    public void makeMove(Board board) { 
        Scanner scanner = new Scanner(System.in); 
        boolean validMove = false; 

        while (!validMove) {
            System.out.println(getName() + ", enter a valid move in the format (row,col): ");
            String input = scanner.nextLine();
            // Validate format: Must start with '(' and end with ')'
            if (!input.startsWith("(") || !input.endsWith(")")) {
                System.out.println("Invalid format. Please use (row,col) format.");
                continue; //ask for input again if format is invalid 
            }
    
            try {
                String[] parts = input.replaceAll("[()]", "").split(","); // Remove parentheses and split by comma delimeter
                int row = Integer.parseInt(parts[0].trim()) - 1; // Convert to 0-based index, trim leading or following spaces making it easier to place for row/col
                int col = Integer.parseInt(parts[1].trim()) - 1; 
    
                // Validate row and column
                if (row >= 0 && row < board.getSize() && col >= 0 && col < board.getSize()) { //verify the row/col are within board size
                    if (board.isCellEmpty(row, col)) { //if the space they want is empty
                        board.updateBoard(row, col, getSymbol()); //place their symbol 
                        validMove = true;
                    } else {
                        System.out.println("Cell is already occupied. Try again.");
                    }
                } else {
                    System.out.println("Invalid move. Please enter a row and column within the board dimensions.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input format. Please enter your move as (row,col) within bounds of board size.");
            }
        }

        }

}
