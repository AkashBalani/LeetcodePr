import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Accepted Solution
@SuppressWarnings("unchecked")
class Solution{
    public boolean isValidSudoku(char[][] board){
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] cols = new HashMap[9];
        HashMap<Integer, Integer> [] boxs = new HashMap[9];

        for(int i = 0; i < 9; i++){
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxs[i] = new HashMap<Integer, Integer>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char num = board[i][j];
                int n = (int)num;

                int box_index = (i / 3) * 3 + (j / 3);

                rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                boxs[box_index].put(n, boxs[box_index].getOrDefault(n, 0) + 1);

                if(rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxs[box_index].get(n) > 1)
                    return false;
            }
        }
        return true;
    }
}

class Solution1{
    public boolean isValidSudoku(char[][] board){
        Set<E> seen = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char number = board[i][j];
                if(number != '.'){
                    if(!seen.add(number + " in row " + i) ||
                    !seen.add(number + " in column " + j) ||
                    !seen.add(number + " in block " + i/3 + "-" + j/3)
                    )
                        return false;
                }
            }
        }
        return true;
    }
}