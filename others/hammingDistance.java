class Solution{
    public int hammingDistance(int x, int y){
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }
}

class Solution1{
    public int hammingDistance(int x, int y){
        int xor = x ^ y;
        int dist = 0;
        while(xor != 0){
            if(xor % 2 == 1){ // WE can also use xor & 1 == 1
                dist += 1;
                xor = xor >> 1;
            }
        }
        return dist;
    }
}

class Solution2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int dist = 0;
        while(xor != 0){
            dist += 1;
            xor &= (xor - 1);
        }
        return dist;
    }
}