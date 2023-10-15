package juego.cenec1;

import javax.swing.*;
import java.util.Random;

public class Metodos {
    private final int SIZE = 10;
    private final char WATER = '~';
    private final char SHIP = 'S';
    private final char HIT = 'X';
    private final char MISS = 'O';

    public char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = WATER;
            }
        }
        return board;
    }

    public void placeShips(char[][] board, boolean isAI) {
        int[] ships = {2, 3, 4, 5};
        for (int ship : ships) {
            placeSingleShip(board, ship, isAI);
        }
    }

    private void placeSingleShip(char[][] board, int shipSize, boolean isAI) {
        Random random = new Random();
        boolean placed = false;
        while (!placed) {
            int x = random.nextInt(SIZE);
            int y = random.nextInt(SIZE);
            boolean horizontal = random.nextBoolean();
            if (canPlaceShip(board, x, y, shipSize, horizontal)) {
                for (int i = 0; i < shipSize; i++) {
                    if (horizontal) {
                        board[x][y + i] = SHIP;
                    } else {
                        board[x + i][y] = SHIP;
                    }
                }
                placed = true;
            }
        }
    }

    private boolean canPlaceShip(char[][] board, int x, int y, int shipSize, boolean horizontal) {
        for (int i = 0; i < shipSize; i++) {
            if (horizontal) {
                if (y + i >= SIZE || board[x][y + i] == SHIP) {
                    return false;
                }
            } else {
                if (x + i >= SIZE || board[x + i][y] == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAllShipsSunk(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean shoot(char[][] board, int x, int y) {
        if (board[x][y] == SHIP) {
            board[x][y] = HIT;
            return true;
        } else {
            board[x][y] = MISS;
            return false;
        }
    }

    public int[] aiShoot(char[][] board) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (board[x][y] == HIT || board[x][y] == MISS);

        shoot(board, x, y);
        return new int[]{x, y};
    }

    public String boardToString(char[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                builder.append(board[i][j]).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
