package strategy;

import game.Board;
import model.Symbol;

public class RowWinning  implements Winning{
    @Override
    public boolean evaluate(Board board) {
        int n = board.getSize();

        for(int i=0; i<n; i++) {
            Symbol currSym = board.get(i, 0);
            if (currSym != Symbol.EMP) {
                int j = 1;
                while (j < n) {
                    if (!currSym.equals(board.get(i, j))) {
                        break;
                    }

                    j++;
                }
                if (j == n) {
                    return true;
                }
            }
        }

        return false;
    }
}
