public class Solution {
    public int countSubstrings(String s) {
        // if we get one character, the output is 1
        // if we get 2 inputs, both of the characters are different, output is 2
        //                     if both characters are same, output is 3
        // if we get 3 inputs, both of 
        int count = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
            count += 1;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == s.charAt(i)){
                dp[i - 1][i] = true;
                count += 1;
            }
        }
        for(int j = 2; j < s.length(); j++){
            for(int i = 0; i < j; i++){
                if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    count += 1;
                }
            }
        }
        return count;
    }
}
