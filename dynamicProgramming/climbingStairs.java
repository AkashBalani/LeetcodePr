// Initial Attempt
// Time Limit Exceeded
class Solution{
    public int climbStairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        else return climbStairs(n-1) + climbStairs(n-2);
    }
}

// Through Dynamic Programming
// Accepted Solution
class Solution1{
    public int climbStairs(int n){
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Uses Fibonaci Sequence
// The difference between this one and the one before it is space complexity
class Solution2{
    public int climbStairs(int n){
        if(n == 1) return 1;
        int first = 1;
        int second = 2;
        for(int i = 3; i <= n; i++){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}