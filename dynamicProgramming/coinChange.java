public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return helper(coins, amount, new int[amount]);
    }

private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
    if(rem<0) return -1; // not valid
    if(rem==0) return 0; // completed
    if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
    int min = Integer.MAX_VALUE;
    for(int coin : coins) {
        int res = helper(coins, rem-coin, count);
        if(res>=0 && res < min)
            min = 1+res;
    }
    count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
    return count[rem-1];
    }
}

public class Solution1{
    public int coinChange(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, amount + 1);
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

/*
    coins = [1, 2, 5], amount = 11
    coinChange(int amount, int[] coins)
        dp = new int[12]
        dp -> int[]{12, 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12}
        for(int i = 1; i < dp.length; i++)
            for(int j = 1; j < coins.length; j++)
                if(2 <= 1)
*/