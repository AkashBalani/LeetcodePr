class Solution{
    public boolean isPowerOfThree(int n){
        if(n < 1)
            return false;

        while(n % 3 == 0)
            n /= 3;

        return n == 1;
    }
}

class Solution1{
    public boolean isPowerOfThree(int n){
        return Integer.toString(n, 3).matches("^10*$");
    }
}

public class Solution2 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}