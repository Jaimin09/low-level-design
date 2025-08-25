package strategy;

import game.Board;
import model.Symbol;

public class ColumnWinning implements Winning {
    @Override
    public boolean evaluate(Board board) {
        int n = board.getSize();

        for(int j=0; j<n; j++) {
            Symbol currSym = board.get(0, j);
            if (currSym != Symbol.EMP) {
                int i = 1;
                while (i < n) {
                    if (!currSym.equals(board.get(i, j))) {
                        break;
                    }

                    i++;
                }
                if (i == n) {
                    return true;
                }
            }
        }

        return false;
    }
}
