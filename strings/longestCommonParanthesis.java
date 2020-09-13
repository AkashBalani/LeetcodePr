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

public class Solution1 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}

/*
    s --> "(()"
    longestValidParentheses("(()")
        maxans = 0;
        int dp[] = new int[3];
        for(int i = 2; i < 3; i++)
            if(s.charAt(2) == ')') (T)
                if(s.charAt(1) == '(') (T)
                    i >= 2 ? dp[0] : 0 + 2
                    dp[2] = 2
            maxans = max(0, 2) = 2
    return 2;

    s --> "())((())"
    maxans --> 2
    longestValidParentheses("())((())")
        maxans = 0
        int dp = new int[8];
        for(int i = 7; i < 8; i++)
            if(s.charAt(7) == ')') (T)
                if(s.charAt(6) == '(') (F)
                i - dp[i - 1] > 0 --> 7 - 2 > 0 (T)
                s.charAt(7 - 2 - 1) --> s.charAt(4) --> (T)
                else if(T & T)
                    dp[7] = 4;
        maxans = 4
*/

public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                }
                else{
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
/*
    s --> "())((())"
    longestValidParentheses("())((())")
        maxans = 2;
        stack -> [2, 3]
        for(int i = 7; i < 8; i++)
            if(F)
            else
                stack.pop()
                if(F)
                else
                    maxans = max(2, 4) = 4
    return 4
*/