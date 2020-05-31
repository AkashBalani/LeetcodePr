class Solution{
    public int editDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        if((n * m) == 0)
            return n + m;
        
        int[][] dist = new int[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++){
            dist[i][0] = i; 
        }
        for(int j = 0; j < m + 1; j++){
            dist[0][j] = j;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                int left = dist[i - 1][j] + 1;
                int down = dist[i - 1][j - 1] + 1;
                int left_down = dist[i - 1][j - 1];
                if(word1.charAt(i - 1) != word2.charAt(j - 1)
                    left_down += 1;
                dist[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dist[n][m];
    }
}