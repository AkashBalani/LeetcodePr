import java.util.Stack;


// Passed a few test cases
class Solution{
    public boolean checkValidString(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(s.charAt(i));
            else if(s.charAt(i) == ')'){
                if(stack.search('(') == -1) return false;
                else stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}

class Solution1{
    public boolean checkValidString(String s){
        int bal = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*') bal++;
            else if(bal-- == 0) return false;
        }
        if(bal == 0) return true;
        bal = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ')' || s.charAt(i) == '*') bal++;
            else if(bal-- == 0) return false;
        }
        return true;
    }
}