class Solution{
    public int uncrossedLines(int[] A, int[] B){
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        // Here we know that all the elements of dp would be filled with zeros
        // This is the same code for LCS (Longest Common Subsequence)
        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= n; ++j){
                if(A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}