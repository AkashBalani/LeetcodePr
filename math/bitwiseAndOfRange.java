class Solution{
    public int bitwiseAnd(int m, int n){
        int result = m;
        for(int start = m; start <= n; start++){
            result &= start;
        }
        return result;
    }
}