// Time Limit Exceeded

class Solution{
    public int bitwiseAnd(int m, int n){
        int result = m;
        for(int start = m; start <= n; start++){
            result &= start;
        }
        return result;
    }
}

// Accepted Solution
class Solution{
    public int rangeBitwiseAnd(int m, int n){
        int shift = 0;
        while(m < n){
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}