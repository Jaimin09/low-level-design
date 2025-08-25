package state;

import game.Game;
import model.GameResult;

public class FinishedState implements State {
    @Override
    public void startGame(Game game) {
        System.out.println("Game ended");
    }

    @Override
    public boolean makeMove(Game game, int x, int y) {
        System.out.println("Game ended");
        return false;
    }

    @Override
    public void announceWinner(Game game) {
        if (game.getGameResult() == GameResult.WON) {
            System.out.println("Game won by: " + game.getWinningPlayer().getUserId());
        } else if (game.getGameResult() == GameResult.DRAW) {
            System.out.println("Game drawn!");
        } else {
            throw new RuntimeException("Cannot fetch game result");
        }
    }
}
