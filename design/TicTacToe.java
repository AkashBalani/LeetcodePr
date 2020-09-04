public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col)
        {
            diagonal += toAdd;
        }
        
        if (col == (cols.length - row - 1))
        {
            antiDiagonal += toAdd;
        }
        
        int size = rows.length;
        if (Math.abs(rows[row]) == size ||
            Math.abs(cols[col]) == size ||
            Math.abs(diagonal) == size  ||
            Math.abs(antiDiagonal) == size)
        {
            return player;
        }
        
        return 0;
        }
    }

// TicTacToe tick = new TicTacToe(3);
//   rows = new int[3];
//   cols = new int[3];
// tick.move(0, 0, 1)
//   toAdd = 1
//   rows[0] = 0 + 1
//   cols[0] = 0 + 1
//   if(0 == 0)
//     diagonal = 0 + 1
//   if(0 == 3 - 0 - 1) (F)
//   size = 3
//   if(1 == 3 || 1 == 3 || 1 == 3 || 0 == 3) (F)
//   return 0
// tick.move(0, 2, 2)
//   toAdd = -1
//   rows[0] = 1 - 1 = 0
//   cols[2] = 0 - 1 = -1
//   if(0 == 2) (F)
//   if(2 == 3 - 0 - 1)
//     antiDiagonal = -1
//   int size = 3
//   if(0 == 3 || 1 == 3 || 1 == 3 || 1 == 3) (F)
//   return 0
// tick.move(2, 2, 1)
//   toAdd = 1
//   rows[2] = 0 + 1 = 1
//   cols[2] = -1 + 1 = 0
//   if(2 == 2)
//     diagonal = 2
//   if(2 == 3 - 2 - 1) (F)
//   size = 3
//   if(1 == 3 || 0 == 3 || 2 == 3 || 1 == 3) (F)
//   return 0
// tick.move(1, 1, 2)
//   toAdd = -1
//   rows[1] = 0 - 1 = -1
//   cols[1] = 0 - 1 = -1
//   if(1 == 1)
//     diagonal = 2 - 1 = 1
//   if(1 == 3 - 1 - 1)
//     antidiagonal = -1 -1 = -2
//   size = 3
//   if(1 == 3 || 1 == 3 || 1 == 3 || 2 == 3) (F)
//   return 0