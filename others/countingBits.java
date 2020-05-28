class Solution{
    public int[] countingBits(int num){
        int[] ans = new int[num + 1];
        for(int i = 0; i <= num; i++){
            ans[i] = popcount(i);
        }
        return ans;
    }

    private int popcount(int x){
        int count;
        for(count = 0; x != 0; ++count){
            x &= (x-1);
        }
        return count;
    }
}

class Solution1{
    public int countingBits(int num){
        int[] ans = new int[num + 1];
        int i = 0, b = 1;
        while(b <= num){
            while(i < b && (b + i) <= num){
                ans[i + b] = ans[i] + 1;
                ++i;
            }
            i = 0;
            b <<= 1;
        }
        return ans;
    }
}

class Solution2{
    public int countingBits(int num){
        int[] ans = new int[num + 1];
        for(int i = 1; i <= num; ++i){
            ans[i] = ans[i>>1] + (i & 1);
        }
        return ans;
    }
}