// Passed some test cases
class Solution{
    public boolean checkIfStraight(int[][] coordinates){
        int len = coordinates.length;
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        int m = (y - y1) / (x - x1);
        for(int i = 2; i < len; i++){
            int xa = coordinates[i - 1][0];
            int ya = coordinates[i - 1][1];
            int xb = coordinates[i][0];
            int yb = coordinates[i][1];
            int m1 = (ya - yb) / (xa - xb);
            if(m != m1) return false;
        }
        return true;
    }
}

// Last solution was failing because of the slope calculation
class Solution1{
    public boolean checkIfStraight(int[][] coordinates){
        int x = coordinates[0][0];
        int y = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        int dx = (x1 - x);
        int dy = (y1 - y);
        for(int[] co : coordinates){
            int xa = co[0];
            int ya = co[1];
            if((dx * (ya - y1)) != (dy * (xa - x1))) return false;
        }
        return true;
    }
}