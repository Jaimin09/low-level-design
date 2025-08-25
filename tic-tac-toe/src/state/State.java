package state;

import game.Game;
import model.Player;

public interface State {
    void startGame(Game game);
    boolean makeMove(Game game, int x, int y);
    void announceWinner(Game game);
}
