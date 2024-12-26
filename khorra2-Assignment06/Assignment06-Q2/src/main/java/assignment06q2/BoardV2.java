package assignment06q2;


public class BoardV2 extends Board {
    protected int M; //marker for new winning Condition
    protected int size;

    public BoardV2(int size, int M) { 
        super(size); //refer to parent class 
        this.size = size;
        this.M = M;
        
        
    }
    @Override
    protected boolean checkRows(char symbol) { //check for winning rows based off specific marker 
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == symbol) {
                    count++; //count symbol placement on specific row
                    if (count == M) { //verify winning condition
                        return true; 
                    }
                    
                } else { 
                    count = 0; //reset count 
                }
            }
            
            } return false; 
        }
        
    @Override
    protected boolean checkColumns(char symbol) {
        for (int j = 0; j < size; j++) { //iterate columns first to check for column winning condition
            int count = 0;
            for (int i = 0; i < size; i++) { 
                if (grid[i][j] == symbol) { 
                    count++; //count placement of symbol on current column
                    if (count == M) {  //if winning condition is met return true
                        return true;
                    }
                } else { 
                    count = 0; //meaning the column has no symbols yet
                }
            }
            
        }
        return false; 
        
    }
    @Override
    protected boolean checkDiagonal(char symbol) { 
        //Checking main diagonal top left to bottom right
        for (int start = 0; start <= size - M; start++) {
            int countMain = 0, countAnti = 0;
            for (int i = 0; i < size - start; i++) { //loop through cells on main diagonal (start,0)
                if (grid[start + i][i] == symbol) {
                    countMain++;
                    if (countMain == M) {//winning condition is met if M symbols in a straight diagonal line
                        return true;
                    }
                } else {
                    countMain = 0; //reset count if symbol doesn't match
                }
    
                if (grid[i][start + i] == symbol) { //checking for anti-diagonal (top-right to bottom left)
                    countAnti++;
                    if (countAnti == M) {
                        return true; }
                } else {
                    countAnti = 0; //reset count if symbol doesn't match
                }
            }
        }
    
        // looping through all possible starting points for anti-diagonals top right to bottom left
        for (int start = 0; start <= size - M; start++) {
            int countMain = 0, countAnti = 0;
            for (int i = 0; i < size - start; i++) { //loop through cells along the main diagonal (starting at start, size-1)
                if (grid[start + i][size - i - 1] == symbol) {
                    countMain++;
                    if (countMain == M) { 
                        return true; }
                } else {
                    countMain = 0;
                }
    
                if (grid[i][size - start - i - 1] == symbol) {
                    countAnti++;
                    if (countAnti == M) { 
                        return true; }
                } else {
                    countAnti = 0;
                }
            }
        }
        return false;
}
@Override
public boolean winStatus(char symbol) {
    return checkRows(symbol) || checkColumns(symbol) || checkDiagonal(symbol);
}
    }
