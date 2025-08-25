package game;

import lombok.Getter;
import model.Symbol;

import java.util.Objects;

public class Board {
    int n;
    Symbol[][] board;

    public Board(int n) {
        board = new Symbol[n][n];
        this.n = n;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = Symbol.EMP;
            }
        }
    }

    public int getSize() {
        return n;
    }
    public Symbol get(int x, int y) {
        return board[x][y];
    }

    public boolean isValid(int x, int y) {
        return x < n && x >= 0 && y < n && y >= 0 && Objects.equals(board[x][y], Symbol.EMP);
    }

    public void markCell(Symbol symbol, int x, int y) {
        board[x][y] = symbol;
    }

    public boolean isFull() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == Symbol.EMP) {
                    return false;
                }
            }
        }
        return true;
    }

}
