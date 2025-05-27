public class Board {
    private String[][] board = new String[10][10];
    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    
    public Board() {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board.length; j++) {
                board[i][j] = "[]";
            }
        } 
    }
    public String getCoord(int row, int column) {
        return board[row][column];
    }
    public void setBoard(int row, int column, String value) {
        board[row][column] = value;
    }
    public int letterToNum(String letter) {
        for(int i = 0; i<letters.length; i++) {
            if(letter.equals(letters[i])) {
                return i;
            }
        }
        return -1;
    }
    public void displayBoard() {
        System.out.println(" 1 2 3 4 5 6 7 8 9 10");
        for(int i =0; i<board.length; i++) {
            System.out.print(letters[i]);
            for(int j = 0; j<board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
    public boolean checkShip(String move) {
        if (!(move.length() == 5 || move.length() == 6 || move.length() == 7)) {
            System.out.println("Incorrect length");
            return false;
        }
        if(letterToNum(move.substring(1,2)) == -1) {
            System.out.println("Use a letter from A-J");
            return false;
        }
        try {
            if(!(Integer.valueOf(move.substring(2,3)) >= 1 || Integer.valueOf(move.substring(2,3)) <= 10)) {
                System.out.println("Number must be between 1-10");
                return false;
            }
        } catch (NumberFormatException e){
            System.out.println("You put a letter where a number needs to be");
            return false;
        }
        return true;
    }
    public boolean placeShip(String move, int length, String type) {
        if(move.substring(0,1).equals("H")) {
            if(move.length() == 5 || move.length() == 6) {
                if(move.length() == 5) {
                    if(move.substring(1,2).equals(move.substring(3,4))) {
                        if(Integer.valueOf(move.substring(4,5))-Integer.valueOf((move.substring(2,3)))==length-1) {
                            for(int i = 0; i<length; i++) {
                                if(!(board[letterToNum(move.substring(1,2))][Integer.valueOf(move.substring(2,3))+i-1].equals("[]"))) {
                                    System.out.println("A ship is occupying that spot.");
                                    return false;
                                }
                            }
                            for(int i = 0; i<length; i++) {
                                board[letterToNum(move.substring(1,2))][Integer.valueOf(move.substring(2,3))+i-1] = type;
                            }
                            return true;
                        }
                        System.out.println("The difference of your numbers need to be the length specified. 1-4 is considered 4 units apart.");
                        return false;
                    }
                    System.out.println("For horizontal, rows need to be same");
                    return false;
                }
                else {
                    if(move.substring(1,2).equals(move.substring(3,4))) {
                        if(Integer.valueOf(move.substring(4,6))-Integer.valueOf((move.substring(2,3)))==length-1) {
                            for(int i = 0; i<length; i++) {
                                board[letterToNum(move.substring(1,2))][Integer.valueOf(move.substring(2,3))+i-1] = type;
                            }
                            return true;
                        }
                        System.out.println("The difference of your numbers need to be the length specified. 1-4 is considered 4 units apart.");
                        return false;
                    }
                    System.out.println("For horizontal, rows need to be same");
                    return false;
                }
            }
            System.out.println("Incorrect length.");
            return false;
        }
        else if(move.substring(0,1).equals("V")) {
            if(move.length() == 5 || move.length() == 7) {
                if(move.length() == 5) {
                    if(move.substring(2,3).equals(move.substring(4,5))) {
                        if(letterToNum(move.substring(3,4))-letterToNum((move.substring(1,2)))==length-1) {
                            for(int i = 0; i<length; i++) {
                                if(!(board[letterToNum(move.substring(1,2))+i][Integer.valueOf(move.substring(2,3))-1].equals("[]"))) {
                                    System.out.println("A ship is occupying that spot.");
                                    return false;
                                }  
                            }       
                            for(int i = 0; i<length; i++) {
                                board[letterToNum(move.substring(1,2))+i][Integer.valueOf(move.substring(2,3))-1] = type;
                            }
                            return true;
                        }
                        System.out.println("The differnce between your letter must be the length specified apart. A to D is considered 4 letters apart.");
                        return false;
                    }
                    System.out.println("For vertical numbers need to be equal.");
                    return false;
                }
                else {
                    if(move.substring(2,4).equals(move.substring(5,7))) {
                        if(letterToNum(move.substring(4,5))-letterToNum((move.substring(1,2)))==length-1) {
                            for(int i = 0; i<length; i++) {
                                board[letterToNum(move.substring(1,2))+i][Integer.valueOf(move.substring(2,4))-1] = type;
                            }
                            return true;
                        }
                        System.out.println("The differnce between your letter must be the length specified apart. A to D is considered 4 letters");
                        return false;
                    }
                    System.out.println("For vertical, numbers must be equal.");
                    return false;
                }
            }
            System.out.println("Incorrect length");
            return false;
        }
        System.out.println("First letter needs to specify either H meaning horizontal or V meaning vertical.");
        return false;
    }
    public boolean checkMove(Board board, String move, int length, String type) {
        try {
            if(board.checkShip(move)==true) {
                if(board.placeShip(move, length, type) == true) {
                    board.displayBoard();
                    return true;
                }
                return false;
            }
            return false;
        }
        catch (StringIndexOutOfBoundsException e) {
            System.out.println("Not valid");
            return false;
        }
    }
}