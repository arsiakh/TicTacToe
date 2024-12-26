package assignment06q2;


public abstract class Player {
     
    protected char symbol;
    protected String name; 

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() { //retrieve name 
        return name; 
    }

    public char getSymbol() { //retrieve symbol
        return symbol;
    }

   

    

    public abstract void makeMove(Board board); //abstract method for Human and Computer class, as they pose different functionalities 


    }

    


    

