import game.Game;
import model.Player;
import model.Symbol;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(Objects.equals(Symbol.X, Symbol.X));
        Player alice = new Player("alice", Symbol.O);
        Player bob = new Player("bob", Symbol.X);

        Game game = new Game(alice, bob, 3);

        System.out.println("========= GAME 1 =========");

        game.startGame();
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        game.makeMove(1, 2);  // Alice already won

        System.out.println("========= GAME 2 =========");
        game.startGame();
        game.makeMove(2, 0);
        game.makeMove(2, 0); // Not allowed
        game.makeMove(0, 0); // x
        game.makeMove(0, 1);
        game.makeMove(1, 0); // x
        game.makeMove(1, 1);
        game.makeMove(2, 1); // x
        game.makeMove(1, 2);
        game.makeMove(0, 2); // x
        game.makeMove(2, 2);

    }
}

/*

x o x
x o o
o x o
 */
/*
--------
GAME
- PlayerO
- PlayerX
- currentPlayer
- currentState
- makeMove(playerId, i, j)
- checkWinning()
-

BOARD
- SYM[][]
- n (dims)
- isValid(SYM, i, j)
- markCell(SYM, i, j)
-
 */