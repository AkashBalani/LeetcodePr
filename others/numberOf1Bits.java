
// Accepted Solution
class Solution{
    public int hammingDistance(int n){
        int bits = 0, mask = 1;
        for(int i = 0; i < 32; i++){
            if((n & mask) != 0)
                bits++;
            mask <<= 1;
        }
        return bits;
    }
}