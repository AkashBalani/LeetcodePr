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