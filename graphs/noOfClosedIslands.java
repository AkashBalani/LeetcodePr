class Solution {
    int fill(int[][] g, int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 0)
        return 0;
    return (g[i][j] = 1) + fill(g, i + 1, j) + fill(g, i, j + 1) + fill(g, i - 1, j) + fill(g, i, j - 1);
    }
    public int closedIsland(int[][] g) {
        for (int i = 0; i < g.length; ++i)
            for (int j = 0; j < g[i].length; ++j)
                if (i * j * (i - g.length + 1) * (j - g[i].length + 1) == 0)
                    fill(g, i, j);
        int res = 0;
        for (int i = 0; i < g.length; ++i)
            for (int j = 0; j < g[i].length; ++j)
                res += fill(g, i, j) > 0 ? 1 : 0;
    return res;
    }
}

/*
    g = [
    [1,1,1,1,1,1,1,0],
    [1,0,0,0,0,1,1,0],
    [1,0,1,0,1,1,1,0],
    [1,0,0,0,0,1,0,1],
    [1,1,1,1,1,1,1,0]
    ]

    closedIsland(int[][] g)
        for(int i = 0; i < 5; ++i)
            for(int j = 7; j < 8; ++j) //g[0][1] = 0
                if (0 * 0 * (- 6) * (- 9) == 0) (T)
                    fill(g, 0, 7)
                    
    fill(g, 0, 0)
        if (i < 0 || j < 0 || i >= g.length || j >= g[i].length || g[i][j] != 0) (F || F || F || F || F)
    return (g[0][7] = 1) + fill(g, i + 1, j) + fill(g, i, j + 1) + fill(g, i - 1, j) + fill(g, i, j - 1);    
*/

class Solution1 {  
    public int closedIsland(int[][] g) {
	//count the number
        int count = 0; 
        for(int i = 0;i < g.length;i++){
           for(int j = 0;j < g[0].length;j++){
                if(g[i][j] == 0){
                       count += dfs(g,i,j);
                }
           }
        }
        return count;
    }
    private int dfs(int[][] g,int row,int col){
         if(row < 0 || row >= g.length || col < 0 || col >= g[0].length){
                 return 0;//if we meet the edge return 0;
         }
         if(g[row][col] == 1){
                 return 1;//if we meet 1 return 1;
         }
         g[row][col] = 1;
         int up = dfs(g,row-1,col);
         int down = dfs(g,row+1,col);
         int left = dfs(g,row,col-1);
         int right = dfs(g,row,col+1);
         return up & down & left & right;//any of the side meet the edge,is not a island;
    }
}

/*
    g = [
    [1,1,1,1,1,1,1,1],
    [1,0,0,0,0,1,1,1],
    [1,0,1,0,1,1,1,1],
    [1,0,0,0,0,1,0,1],
    [1,1,1,1,1,1,1,0]
    ]

    closedIsland(int[][] g)
        for(int i = 0;i < 5;i++){
           for(int j = 7;j < 8;j++){
                if(g[i][j] == 0){
                       count += dfs(g,i,j);
*/