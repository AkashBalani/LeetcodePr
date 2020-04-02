import java.util.HashSet;
import java.util.Set;

// Accepted Solution

class Solution2{
    private int getNext(int n){
        int totalSum = 0;
        while(n > 0){
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
    
    public boolean isHappyNumber(int n){
        Set<Integer> seen = new HashSet<Integer>();
        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
}