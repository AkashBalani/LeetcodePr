// Notes
// 1. As the input can be shuffled, we'll sort them in their ascending order O(nlogn)
// 2. Secondly you can realize the fact that there is a repeating pattern for number of digits incresing 4 (1, 2, 4, 8) , 3(16, 32, 64), 3(128, 258, 512)
// 3. The input is constrained by (10e9) so we know by this and previous point that power is being checked till (10e29)

class Solution{
    public boolean reorderedPowerOf2(int N){
        char[] str1 = String.valueOf(N).toCharArray();
        // Makes int a char[]
    }
}