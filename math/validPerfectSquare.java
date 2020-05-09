class Solution{
    public boolean isValidSquare(int num){
        if(num < 2) return true;

        long left = 2, right = num / 2, x, guess;
        while(left <= right){
            x = left + (right - left) / 2;
            guess = x * x;
            if(guess == num) return true;
            if(guess > num){
                right = x - 1;
            }
            else{
                left = x + 1;
            }
        }
        return false;
    }
}