package game;

import lombok.Getter;
import lombok.Setter;
import model.GameResult;
import model.Player;
import model.Symbol;
import state.IdleState;
import state.State;
import strategy.ColumnWinning;
import strategy.DiagonalWinning;
import strategy.RowWinning;
import strategy.Winning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    Player player1;
    Player player2;
    @Getter
    Board board;
    @Getter
    Player currentPlayer;
    List<Winning> winningStrategies;
    @Setter
    State currentState;
    @Getter
    @Setter
    GameResult gameResult;
    @Setter
    @Getter
    Player winningPlayer;

    public Game(Player player1, Player player2, int n) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(n);
        this.currentPlayer = player1;
        this.gameResult = null;
        this.currentState = new IdleState();
        this.winningStrategies = List.of(new ColumnWinning(), new RowWinning(), new DiagonalWinning());
    }

    public void startGame() {
        currentState.startGame(this);
    }

    public void announceWinner() {
        currentState.announceWinner(this);
    }

    public void makeMove(int x, int y) {
        if (currentState.makeMove(this, x, y)) {
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    public boolean checkWinner() {
        for(Winning winning : winningStrategies) {
            if (winning.evaluate(board)) {
                System.out.println(winning.toString());
                return true;
            }
        }
        return false;
    }

}
