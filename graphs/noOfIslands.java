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