package state;

import game.Board;
import game.Game;
import model.GameResult;
import model.Player;

public class InProgressState implements State {
    @Override
    public void startGame(Game game) {
        System.out.println("game already started");
    }

    @Override
    public boolean makeMove(Game game, int x, int y) {
        Player player = game.getCurrentPlayer();
        Board board = game.getBoard();

        System.out.println("player " + player.getUserId() + " moves - (" + x + "," + y + ")");
        if (board.isValid(x, y)) {
            board.markCell(player.getSymbol(), x, y);
            if (game.checkWinner()) {
                game.setCurrentState(new FinishedState());
                game.setGameResult(GameResult.WON);
                game.setWinningPlayer(player);
                game.announceWinner();
            } else if (board.isFull()) {
                game.setGameResult(GameResult.DRAW);
                game.setCurrentState(new FinishedState());
                game.announceWinner();
            }
            return true;
        } else {
            System.out.println("Invalid move, cell is already marked");
            return false;
        }
    }

    @Override
    public void announceWinner(Game game) {
        System.out.println("Game is in progress");
    }
}
