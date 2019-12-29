
// Initial Brute Force
// Accepted Answer

class Solution {
    public int reverse(int x) {
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE)
                return 0;
        if(x < 0){
            x *= -1;
            String temp = Integer.toString(x);
            int[] newGuess = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++){
                newGuess[i] = temp.charAt(i) - '0';
            }
            int betterGuess = 0;
            for(int i = 0, j = newGuess.length - 1; i < j; i++, j--){
                int temp1 = newGuess[i];
                newGuess[i] = newGuess[j];
                newGuess[j] = temp1;
            }
            for(int i = 0; i < newGuess.length; i++){
                betterGuess += newGuess[i]*Math.pow(10, (newGuess.length - 1) - i );                
            }
            if(betterGuess >= Integer.MAX_VALUE || betterGuess <= Integer.MIN_VALUE)
                return 0;
            return betterGuess *= -1;
            
        }
        else{
            String temp = Integer.toString(x);
            int[] newGuess = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++){
                newGuess[i] = temp.charAt(i) - '0';
            }
            int betterGuess = 0;
            for(int i = 0, j = newGuess.length - 1; i < j; i++, j--){
                int temp1 = newGuess[i];
                newGuess[i] = newGuess[j];
                newGuess[j] = temp1;
            }
            for(int i = 0; i < newGuess.length; i++){
                betterGuess += newGuess[i]*Math.pow(10, (newGuess.length - 1) - i );                
            }
            if(betterGuess >= Integer.MAX_VALUE || betterGuess <= Integer.MIN_VALUE)
                return 0;
            return betterGuess;
        }
    }
}

// Advanced Solution

class Solution {
    public int reverse(int x)
    {
        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) // This line only checks if result * 10 leads to overflow
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}