class Solution {
    public int getSum(int a, int b) {
        int carry = a & b;
        int result = a ^ b;
        while(carry != 0){
            int shiftedcarry = carry << 1;
            carry = result & shiftedcarry;
            result ^= shiftedcarry;
        }
        return result;
    }
}