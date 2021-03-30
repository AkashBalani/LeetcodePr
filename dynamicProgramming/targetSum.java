// Similar to 0/1 Knapsack

// Recursive code
// O(2^n)
public class Main {
    int count = 0;
    public static void main(String[] args) {
      Main main = new Main();
      int[] nums = new int[]{1, 1, 1, 1, 1};
      int target = 3;
      System.out.println(main.findTargetSumWays(nums, target));
    }
    public int findTargetSumWays(int[] nums, int S) {
      calculate(nums, 0, 0, S);
      return count;
    }
    public void calculate(int[] nums, int i, int sum, int S){
      if (i == nums.length){
        if(sum == S)
          count++;
        }
        else {
          calculate(nums, i+1, sum+nums[i], S);
          calculate(nums, i+1, sum-nums[i], S);
        }
    }
}

// This Solution just adds Memoization
public class Main1 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }
}


// Need to study this one
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
}
