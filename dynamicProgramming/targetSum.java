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
