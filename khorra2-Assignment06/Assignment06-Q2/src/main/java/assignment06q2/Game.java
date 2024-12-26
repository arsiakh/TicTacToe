package assignment06q2;


public class Game {

    protected Player player1; 
    protected Player player2; 
    protected Player currentPlayer;
    protected Board board;
    

    public Game(Player p1, Player p2, int size) { 
        this.player1 = p1; 
        this.player2 = p2; 
        this.currentPlayer = player1; 
        this.board = new Board(size); //passing size for Board class 
    }
    public void startGame() { 
        while(true) { 
            board.displayBoard();
            System.out.println("It's " + currentPlayer.getName() + "'s turn."); 
            currentPlayer.makeMove(board); //current active player makes a move
            if (board.winStatus(currentPlayer.getSymbol())) { //checking if player has won
                board.displayBoard();
                System.out.println("Game Over!");
                System.out.println(currentPlayer.getName() + " won the game!");
                break; //exit the game loop
            }
            if (isBoardFull()) {
                board.displayBoard();
                System.out.println("Game Over! It's a draw.");
                break;
            }
            
            switchPlayer(); //switch to next players turn 
        }
    }

    public void switchPlayer() { 
        if (currentPlayer == player1) { //switching player method
            currentPlayer = player2;  //ensures currentPlayer will not be the same person twice 
        } else { 
            currentPlayer = player1;

        }
        
    }
    public boolean isBoardFull() {
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.isCellEmpty(i, j)) {
                    return false; // Found an empty cell
                }
            }
        }
        return true; // No empty cells, so board is full
    }

   
    
}
