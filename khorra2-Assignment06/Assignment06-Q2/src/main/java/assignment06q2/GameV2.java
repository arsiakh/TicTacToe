package assignment06q2;
public class GameV2 extends Game {
    protected BoardV2 board;

    public GameV2(Player p1, Player p2, int size, int M) { 
        super(p1, p2, size);
        this.board = new BoardV2(size, M); 
        
    }
    @Override //similar to first startGame method however overrided to use different conditions now; boardsize and winning condition
    public void startGame() { 
        while(true) { 
            board.displayBoard();
            System.out.println("It's " + currentPlayer.getName() + "'s turn."); 
            currentPlayer.makeMove(board);
            if (board.winStatus(currentPlayer.getSymbol())) { //checks if either player has won, by verifying their symbol placement
                board.displayBoard();
                System.out.println("Game Over!");
                System.out.println(currentPlayer.getName() + " won the game!");
                break;
            }
            if (isBoardFull()) {
                board.displayBoard();
                System.out.println("Game Over! It's a draw.");
                break;
            }
            
            switchPlayer(); //gets this from parent class 
        }
    }
    
    
}
