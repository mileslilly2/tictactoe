package tictactoe;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char[][] game = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game[i][j] = ' ';
            }
        }
        
        printBoard(game);
        int moves = 0;
        while (moves < 9) {
            
            System.out.print("Enter the coordinates:");
            
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (x > 0 && x < 4 && y > 0 && y < 4) {
                    int row = x - 1;
                    int col = Math.abs(y - 3);
                    if (game[col][row] == '_' || game[col][row] == ' ') {
                        moves++;
                        if (moves % 2 == 1) {
                            game[col][row] = 'X';
                            printBoard(game);
                        } else {
                            game[col][row] = 'O';
                            printBoard(game);
                        }
                        if(winner(game)) {
                            break;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (Exception e ) {
                System.out.println("You should enter numbers!");
            }
        }
        printBoard(game);
        winner(game);
    }   
        
    
    static void printBoard(char game[][]) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
            if (j == 0) {
                System.out.print("| ");
                }
            System.out.print(game[i][j] + " ");
            if (j == 2) {
                System.out.println("|");
                }   
            }   
        }
        System.out.println("---------");    
        
        
    }



    static boolean winner(char game[][]) {
        
       
        boolean rowWinner = false;
        boolean colWinner = false;
        boolean diagWinner = false;
        int rowIndex = 0;
        int colIndex = 0;
        int countWinner = 0;
        for (int i = 0; i < 3; i++) {
            if (game[i][0] != ' '  && game[i][0] == game[i][1] && game[i][1] == game[i][2]) {
                rowWinner = true;
                countWinner++;
                rowIndex = i;
            }
        }
        for (int i = 0; i < 3; i++) {
             if(game[0][i] != ' ' && game[0][i] == game[1][i] && game[1][i] == game[2][i]) {
                 colWinner = true;
                 countWinner++;
                 colIndex = i;
             }
        }
        if (game[1][1] != ' ' && game[0][0] == game[1][1] && game[1][1] == game[2][2]) {
            diagWinner = true;
            countWinner++;
        } else if (game[1][1] !=  ' ' && game[2][0] == game[1][1] && game[1][1] == game[0][2]) {
            diagWinner = true;
            countWinner++;
        }
        int countO = 0;
        int countX = 0;
        int count_ = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (game[i][j] == 'O') {
                    countO++;
                } else if (game[i][j] == 'X') {
                    countX++;
                    
                } else {
                    count_++;
                }
            }
        }
        if (countWinner > 1) {
            System.out.println("Impossible");
        } else if (Math.abs(countO - countX) > 1) {
            System.out.println("Impossible");
        } else if (rowWinner) {
            System.out.println(game[rowIndex][0] + " wins");
            return true;
        } else if (colWinner) {
            System.out.println(game[0][colIndex] + " wins");
            return true;
        } else if (diagWinner) {
            System.out.println(game[1][1] + " wins");
            return true;
        } else if (countX + countO == 9) {
            System.out.println("Draw");
            return true;
        } else {
            //System.out.println("Game not finished");
            return false;
            }
        return false;
        }
}

    
    
