class Solution {
    public int trailingZeroes(int n) {
        int ans = factCalculator(n);
        int count = 0;
        String number = String.valueOf(ans);
        for(int i = 0; i < number.length(); i++) {
            int j = Character.digit(number.charAt(i), 10);
            if(j == 0)
                count += 1;
        }
        return count;
    }
    public int factCalculator(int n){
        if(n == 1)
            return 1;
        else
            return n*factCalculator(n-1);
    }
}

class Solution1 {
    public int trailingZeroes(int n) {
        
    int zeroCount = 0;
    for (int i = 5; i <= n; i += 5) {
        int currentFactor = i;
        while (currentFactor % 5 == 0) {
                zeroCount++;
                currentFactor /= 5;
            }
        }
        return zeroCount;
    }
}

class Solution2 {
    public int trailingZeroes(int n) {
        int zeroCount = 0;
        // long currentMultiple = 5;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}