class Solution {
    public int minAddToMakeValid(String S) {
        int i = 0;
        int balance = 0;
        Stack<Character> stack = new Stack<Character>();
        while(i < S.length()){
            char ch = S.charAt(i);
            if(ch == '('){
                balance += 1;
                stack.add(ch);
            }
            else if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() != ')'){
                    balance -= 1;
                    stack.pop();
                }
                else{
                    balance += 1;
                }
            }
            i++;
        }
        return balance;
    }
}