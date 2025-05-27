public class Game {
    private int points;
    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    
    public int getPoints() {
        return points;
    }
    public int letterToNum(String letter) {
        for(int i = 0; i<letters.length; i++) {
            if(letter.equals(letters[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkInput(String cds) {
        boolean counter = false;
        if(!(cds.length()==2 || cds.length()==3)) {
            System.out.println("Incorrect format");
            return false;
        }
        for(int i = 0; i < letters.length; i++) {
            if(cds.substring(0,1).equals(letters[i])) {
                counter = true;
                break;
            }
        }
        if(counter == false) {
            System.out.println("First letter needs to be from A-J.");
            return false;
        }
        counter = false;
        if(cds.length()==2) {
            for(int i = 0; i < 10; i++) {
                if(Integer.valueOf(cds.substring(1,2)).equals(i+1)) {
                    counter = true;
                    break;
                }
            }
        }
        else if(cds.length() == 3) {
            if(Integer.valueOf(cds.substring(1,3)) == 10) {
                counter = true;
            }
        }
        if(counter == false) {
            System.out.println("Number needs to be from 1-10.");
            return false;
        }
        return true;
    }
    public boolean attack(String cds, Board board, Board board2, String plr) { 
        if(plr.equals("P1")) {
            if(board2.getCoord(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1).equals("X ") || board.getCoord(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1).equals("O ")) {
                System.out.println("You already hit there!");
                try {
                    Thread.sleep(2000);
                }
                catch(InterruptedException e) {
                    System.out.println("f");
                }
                return false;
            }
        }
        else if(plr.equals("P2")) {
            if(board2.getCoord(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1).equals("X ") || board.getCoord(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1).equals("O ")) {
                System.out.println("You already hit there!");
                try {
                    Thread.sleep(2000);
                }
                catch(InterruptedException e) {
                    System.out.println("f");
                }
                return false;
            }
        }
        
        if(!(board.getCoord(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1).equals("[]"))) {
            switch(board.getCoord(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1)) {
                case "C ":
                    System.out.println("HIT! " + plr + " hit the opponents Carrier!");
                    break;
                case "B ":
                    System.out.println("HIT! " + plr + " hit the opponents Battleship!");
                    break;
                case "R ":
                    System.out.println("HIT! " + plr + " hit the opponents Crusier!");
                    break;
                case "S ":
                    System.out.println("HIT! " + plr + " hit the opponents Submarine!");
                    break;
                case "D ":
                    System.out.println("HIT! " + plr + " hit the opponents Destroyer!");
                    break;
            }
            
            board2.setBoard(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1, "X ");
            points+=10;
            return true;
        }
        else {
            System.out.println("Miss...");
            board2.setBoard(letterToNum(cds.substring(0,1)), Integer.valueOf(cds.substring(1))-1, "O ");
            return true;
        }
    }
}