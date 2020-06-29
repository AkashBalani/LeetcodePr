public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        String t = "";
        for(int i = s.length() - 1; i > 0; i-- ){
            sb.append(s.charAt(i));
        }
        t = sb.toString();
        return Integer.parseInt(t, 2);
    }
}

class Solution1{
    public int reverseBits(int n){
        int copy = n, result = 0;
        for(int i = 0; i < 32; i++){
            result <<= 1;
            if((copy&1) == 1) result += 1;
            copy >>= 1;
        }
        return result;
    }
}