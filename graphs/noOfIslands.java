// Class Solution

class Solution{
    void dfs(char[][] grid, int r, int c){
        int nc = grid[0].length;
        int nr = grid.length;
        if(r > 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0')
            return;

        grid[r][c] = 0;
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public int noOfIslands(char[][] grid){
        int noOfIslands = 0;
        int nc = grid[0].length;
        int nr = grid.length;
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                }
            }
        }
        return noOfIslands;
    }
}

public class Solution {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    DFSMarking(grid, i, j);
                    ++count;
                }
        }    
        return count;
}

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }
}

// grid = [
//   ["0","1","1","1","0"],
//   ["0","1","0","1","0"],
//   ["0","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// count = 0
// n = 4
// if(4 == 0) (F)
// m = 5
// for(i = 0; i < 4; i++)
//   for(int j = 0; j < 5; j++)
//   if(grid[0][0] == '1') (T)
//     dfs(grid, 0, 0)
//       if(0 < 0 || 0 < 0 || 0 >= 4 || 0 >= 5 || 1 != 1) (F)
//       grid[0][0] = 0
//       dfs(grid, 1, 0)
//         if(1 < 0 || 0 < 0 || 1 >= 4 || 0 >= 5 || 1 != 1 )(F)
//         grid[1][0] = 0
//         dfs(grid, 2, 0)
//           if(2 < 0 || 0 < 0 || 2 >= 4 || 0 >= 5 || 1 != 1)(F)
//           grid[2][0] = 0
//           