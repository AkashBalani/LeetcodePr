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

class Solution1 {
    public int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}