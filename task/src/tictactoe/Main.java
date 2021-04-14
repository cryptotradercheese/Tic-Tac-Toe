package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isXWinner = false, isOWinner = false;
        char player = 'X';
        char[][] field = new char[3][3];
        for (int i = 0, counter = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, counter++) {
                field[i][j] = ' ';
            }
        }

        // continue the game
        for (int iteration = 1; !isXWinner && !isOWinner && iteration <= 9; iteration++) {
            System.out.println("---------");
            System.out.println("| " + field[0][0] + " "
                    + field[0][1] + " "
                    + field[0][2] + " |");
            System.out.println("| " + field[1][0] + " "
                    + field[1][1] + " "
                    + field[1][2] + " |");
            System.out.println("| " + field[2][0] + " "
                    + field[2][1] + " "
                    + field[2][2] + " |");
            System.out.println("---------");

            // get coordinates and check for illegal input
            int firstCoordinate, secondCoordinate;
            do {
                System.out.print("Enter the coordinates: ");
                firstCoordinate = scanner.next().charAt(0);
                secondCoordinate = scanner.next().charAt(0);

                if (firstCoordinate < 48 || firstCoordinate > 57 || secondCoordinate < 48 || secondCoordinate > 57) {
                    System.out.println("You should enter numbers!");
                } else if (
                        firstCoordinate < 49 || firstCoordinate > 51 || secondCoordinate < 49 || secondCoordinate > 51
                ) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (
                        field[firstCoordinate - 49][secondCoordinate - 49] == 'O' ||
                                field[firstCoordinate - 49][secondCoordinate - 49] == 'X'
                ) {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } while (
                    firstCoordinate < 48 || firstCoordinate > 57 || secondCoordinate < 48 || secondCoordinate > 57 ||
                    firstCoordinate < 49 || firstCoordinate > 51 || secondCoordinate < 49 || secondCoordinate > 51 ||
                    field[firstCoordinate - 49][secondCoordinate - 49] == 'O' ||
                    field[firstCoordinate - 49][secondCoordinate - 49] == 'X'
            );
            if (iteration % 2 == 1) {
                player = 'X';
            } else if (iteration % 2 == 0) {
                player = 'O';
            }
            field[firstCoordinate - 49][secondCoordinate - 49] = player;

            // analysis for winner
            for (int i = 0; i < 3; i++) {
                // rows
                for (int row = 0; row < 2 && field[i][row] == field[i][row + 1]; row++) {
                    if (row == 1) {
                        if (field[i][row] == 'O') {
                            isOWinner = true;
                        } else if (field[i][row] == 'X') {
                            isXWinner = true;
                        }
                    }
                }
                // columns
                for (int column = 0; column <= 1 && field[column][i] == field[column + 1][i]; column++) {
                    if (column == 1) {
                        if (field[column][i] == 'O') {
                            isOWinner = true;
                        } else if (field[column][i] == 'X') {
                            isXWinner = true;
                        }
                    }
                }
            }
                // main diagonals
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
                if (field[1][1] == 'O') {
                    isOWinner = true;
                } else if (field[1][1] == 'X') {
                    isXWinner = true;
                }
            }
                // secondary diagonals
            if (field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
                if (field[1][1] == 'O') {
                    isOWinner = true;
                } else if (field[1][1] == 'X') {
                    isXWinner = true;
                }
            }
        }

        // output result
        System.out.println("---------");
        System.out.println("| " + field[0][0] + " "
                + field[0][1] + " "
                + field[0][2] + " |");
        System.out.println("| " + field[1][0] + " "
                + field[1][1] + " "
                + field[1][2] + " |");
        System.out.println("| " + field[2][0] + " "
                + field[2][1] + " "
                + field[2][2] + " |");
        System.out.println("---------");

        if (isXWinner) {
            System.out.println("X wins");
        } else if (isOWinner) {
            System.out.println("O wins");
        } else {
            System.out.println("Draw");
        }
    }
}