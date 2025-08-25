package strategy;

import game.Board;
import model.Symbol;

public class DiagonalWinning  implements Winning {
    @Override
    public boolean evaluate(Board board) {
        int n = board.getSize();
        int i=1;

        Symbol currSym = board.get(0, 0);
        if (currSym != Symbol.EMP) {
            for (; i < n; i++) {
                if (board.get(i, i) != currSym)
                    break;
            }
            if (i == n) return true;
        }

        currSym = board.get(0, n-1);
        if (currSym != Symbol.EMP) {
            i = n - 2;
            for (; i >= 0; i--) {
                if (board.get(n - 1 - i, i) != currSym)
                    break;
            }

            if (i == 0) return true;
        }

        return false;
    }
}
