class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();
        for(char ch : charArray){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            if(ch == ')'){
                char c = stack.pop();
                if(c != '(')
                    return false;
            }
            if(ch == ']'){
                char c = stack.pop();
                if(c != '[')
                    return false;
            }
            if(ch == '}'){
                char c = stack.pop();
                if(c != '{')
                    return false;
            }
        }
        return stack.empty();
    }
}