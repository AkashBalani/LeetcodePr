// Accepted Solution //
// Brute Force //

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        Integer alpha = null, beta = null;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                alpha = i;
                if(beta != null) result = Math.min(result, Math.abs(alpha - beta));
            }
            if(words[i].equals(word2)){
                beta = i;
                if(alpha != null) result = Math.min(result, Math.abs(alpha - beta));
            }
        }
        return result;
    }
}