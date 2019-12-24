// Initial Attempt //
// Passed for few test cases //

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int alpha = -1;
        int beta = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                alpha = i;
            }
            if(words[i].equals(word2)){
                beta = i;
                if(alpha != -1)
                    return Math.abs(alpha - beta);
            }
        }
        return Math.abs(alpha - beta);
    }
}