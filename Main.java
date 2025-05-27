import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        while(true) {
            System.out.println("Press \"P\" to start playing, press \"Q\" to quit.");
            String choice = scan.nextLine();
            if(choice.equals("P")) {
                Board board1 = new Board();
                Board board2 = new Board();
                Board boardP1 = new Board();
                Board boardP2 = new Board();
                Game g1 = new Game();
                Game g2 = new Game();
                board1.displayBoard();
                while (true) {
                    System.out.println("P1: Where do you want to place your carrier (Length 5)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board1, move, 5, "C ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P1: Where do you want to place your battleship (Length 4)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board1, move, 4, "B ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P1: Where do you want to place your crusier (Length 3)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board1, move, 3, "R ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P1: Where do you want to place your submarine (Length 3)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board1, move, 3, "S ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P1: Where do you want to place your destroyer (Length 2)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board1, move, 2, "D ")==true) {
                        break;
                    }
                }
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("\n\n\n\n\n\n");
                board2.displayBoard();
                while (true) {
                    System.out.println("P2: Where do you want to place your carrier (Length 5)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board2, move, 5, "C ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P2: Where do you want to place your battleship (Length 4)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board2, move, 4, "B ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P2: Where do you want to place your crusier (Length 3)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board2, move, 3, "R ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P2: Where do you want to place your submarine (Length 3)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board2, move, 3, "S ")==true) {
                        break;
                    }
                }
                while (true) {
                    System.out.println("P2: Where do you want to place your destroyer (Length 2)? Enter the direction either horizontal or vertical, represented by H and V, then right after enter the start coordinate like A1, and right after enter the end coordinate like A5");
                    String move = scan.nextLine();
                    if(board1.checkMove(board2, move, 2, "D ")==true) {
                        break;
                    }
                }
                System.out.println("\n\n\n\n\n\n");
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                while(true) {
                    if(g1.getPoints() == 170) {
                        if(g1.getPoints() == g2.getPoints()) {
                            System.out.println("Tie...");
                            break;
                        }
                        System.out.println("GAME OVER! P1 WINS!");
                        break;
                    }
                    else if(g2.getPoints() == 170) {
                        System.out.println("GAME OVER! P2 WINS!");
                        break;
                    }
                    while(true) {
                        boardP1.displayBoard();
                        System.out.println("P1: Your turn. Enter a coordinate in the format like A1: ");
                        String coord = scan.nextLine();
                        if(g1.checkInput(coord)==true) {
                            if(g1.attack(coord, board2, boardP1, "P1") == true) {
                                try {
                                    Thread.sleep(2000);
                                }
                                catch(InterruptedException e) {
                                    System.out.println("f");
                                } 
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                                break;
                            }  
                        }
                    }
                    while(true) {
                        boardP2.displayBoard();
                        System.out.println("P2: Your turn. Enter a coordinate in the format like A1: ");
                        String coord = scan.nextLine();
                        if(g2.checkInput(coord)==true) {
                            if(g2.attack(coord, board1, boardP2, "P2")==true) {
                                try {
                                    Thread.sleep(2000);
                                }
                                catch(InterruptedException e) {
                                    System.out.println("f");
                                } 
                                System.out.print("\033[H\033[2J");  
                                System.out.flush();
                                break;
                            }
                        }
                    }
                }
            }
            else if(choice.equals("Q")) {
                System.exit(0);
            }
            else {
                continue;
            }
        }
    }
}