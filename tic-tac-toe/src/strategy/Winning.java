package strategy;

import game.Board;

public interface Winning {
    boolean evaluate(Board board);
}
