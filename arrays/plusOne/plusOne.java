// Initial Solution
// Passed a few more testcases


class Solution {
    public int[] plusOne(int[] digits) {
        long result = 0;
        for(int i = 0; i < digits.length; i++){
               result += digits[i] * Math.pow(10, (digits.length-1)-i);
        }
        result += 1;
        String temp = Long.toString(result);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) - '0';
        }
        return newGuess;
    }
}