// Initial Attempt 
// Passed a few test cases

class Solution {
    public int firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length-1; i++){
            for(int j = i; j < ch.length-1; j++){
                if(ch[i] == ch[j]){
                    return i;
                }
            }
        }
        return -1;
    }
}