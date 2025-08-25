package state;

import game.Game;

public class IdleState implements State{

    @Override
    public void startGame(Game game) {
        game.setCurrentState(new InProgressState());
    }

    @Override
    public boolean makeMove(Game game, int x, int y) {
        System.out.println("Game has not started");
        return false;
    }

    @Override
    public void announceWinner(Game game) {
        System.out.println("Game has not started");
    }
}
