package assignment06q1;

public class Board {
    protected int size;
    protected char[][] grid; //instantiates protected 2D array
    
    public int getSize() { 
        return size; //retrieves size
    }

    public Board(int size) { 
        this.size = size;
        this.grid = new char[size][size]; //sets array size
        for (int i = 0; i < size; i++) {  //fills all items of array with a space to be later replaced by symbol
            for (int j = 0; j < size; j++) { 
                grid[i][j] = ' ';
            }
        } 
        
    }

    public void displayBoard() { 
        for (int i = 0; i < size; i++) { 
            for (int j = 0; j < size; j++) { 
                System.out.print(grid[i][j]); //displays array by seperating rows and columns
                if (j < size - 1) { //until the very last column that won't have the seperator 
                    System.out.print("|");
                }

            }            
            System.out.println();
            if (i < size - 1) {  //ensures the last row will not have the seperator
                for (int j = 0; j < size; j++) { 
                    System.out.print("--");
                    
                }
                System.out.println();
            }
        }

        

    }

    public void updateBoard(int row, int col, char symbol) {
        grid[row][col] = symbol; //sets specific row and column from user input to be their symbol
    }

    public boolean isCellEmpty(int row, int col) { 
        return grid[row][col] == ' '; //verifies if symbol is there or not 
    }

    protected boolean checkRows(char symbol) { 
        for (int i = 0; i < size; i++) {
            boolean rowWin = true; //initializes row to be filled so true
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != symbol) { //verifies if row has an element that is not symbol
                    rowWin = false; //row is deemed to not be entirely filled
                    break; //breaks loop for initial row
                }
            }
            if (rowWin) {
                return true;
            }
        }
        return false; 
    }
    protected boolean checkColumns(char symbol) {
        for (int j = 0; j < size; j++) { //same process for row but checks column first 
            boolean colWin = true;
            for (int i = 0; i < size; i++) {
                if (grid[i][j] != symbol) { //verifies if column is completely full or not
                    colWin = false;
                    break;
                }
            }
            if (colWin) {
                return true;
            }
        }
        return false; //returns false indicating column is not full
        
    }

    protected boolean checkDiagonal(char symbol) { 
        boolean mainDiagonalWin = true;
        boolean antiDiagonalWin = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i] != symbol) { //iterates through middle elements 1,1; 2,2; 3,3 to verify if they contain symbol or not 
                mainDiagonalWin = false; //same process as row and column 
                
            }
            if (grid[i][size - i - 1] != symbol) {
                antiDiagonalWin = false;
        }}
        return mainDiagonalWin || antiDiagonalWin; //returns true if either diagonal is completely covered by symbol

       

    }
    public boolean winStatus(char symbol) { //indicates if a player has won in any way through rows, columns or diagonals 
        return checkRows(symbol) || checkColumns(symbol) || checkDiagonal(symbol);
    

   
}

    

}
