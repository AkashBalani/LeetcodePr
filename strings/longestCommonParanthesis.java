class Solution {
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 2; j <= s.length(); j += 2){
                if(isValid(s.substring(i, j))){
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            } else if(!stack.empty() && stack.peek() == '('){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}

/* 
    s -> "(()"
    longestValidParentheses("(()")
        maxlen = 0;
        for(int i = 1; i < 3; i++)
            for(int j = 3; j <= 3; j+=2)
                s.substring(1, 3) --> "()"
                if(isValid("()")) --> if(T)
                    maxlen = max(0, 2) = 2
    return 2;

    isValid("()")
        for(int i = 0; i < 2; i++)
            if(T)
                stack --> ["("]
            else if(T)
                stack --> []
    return True;
*/
